package br.com.alura_challenge.literalura.mapper;

import br.com.alura_challenge.literalura.dto.BookData;
import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.model.Book;
import br.com.alura_challenge.literalura.model.Language;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {
    public static Book toEntity(BookData data) {
        Book book = new Book();
        book.setTitle(data.title());
        book.setDownloadsNumber(data.downloadsNumber());

        // Converte autores
        List<Author> authors = data.authors().stream()
                .map(AuthorMapper::toEntity)
                .peek(author -> author.getBooks().add(book))
                .toList();
        book.setAuthor(authors);

        // Converte idiomas
        List<Language> languages = data.languages().stream()
                .map(code -> {
                    Language lang = new Language(code);
                    lang.getBooks().add(book);
                    return lang;
                })
                .toList();
        book.setLanguage(languages);

        return book;
    }
}