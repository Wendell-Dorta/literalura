package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.dto.BookData;
import br.com.alura_challenge.literalura.dto.BookResultsData;
import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.model.Book;
import br.com.alura_challenge.literalura.model.Language;
import br.com.alura_challenge.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final GutendexApiHelper helper;
    private final BookRepository repository;
    private final AuthorService authorService;
    private final LanguageService languageService;

    public BookService(BookRepository repository, AuthorService authorService, LanguageService languageService, GutendexApiHelper helper) {
        this.repository = repository;
        this.authorService = authorService;
        this.languageService = languageService;
        this.helper = helper;
    }

    private Optional<BookData> getBookData(String bookName) {
        String url = helper.getEndereco() + "search=" + bookName.replace(" ", "+");
        var json = helper.getApi().getData(url);
        BookResultsData resultsData = helper.getConvertData().getData(json, BookResultsData.class);

        if (resultsData.results().isEmpty()) {
            System.out.println("Nenhum livro encontrado para: " + bookName);
            return Optional.empty();
        }

        return Optional.of(resultsData.results().get(0));
    }

    public void searchBooksWeb(String bookName) {
        Optional<BookData> bookDataOptional = getBookData(bookName);

        if (bookDataOptional.isEmpty()) {
            return;
        }

        BookData bookData = bookDataOptional.get();
        Optional<Book> existingBook = repository.findByTitleIgnoreCase(bookData.title());

        if (existingBook.isPresent()) {
            System.out.println(existingBook.get());
            return;
        }

        List<Author> managedAuthors = authorService.findAndSaveAuthors(bookData.authors());
        List<Language> managedLanguages = languageService.findAndSaveLanguages(bookData.languages());

        Book book = new Book();
        book.setTitle(bookData.title());
        book.setDownloadsNumber(bookData.downloadsNumber());

        book.setAuthor(managedAuthors);
        book.setLanguage(managedLanguages);

        repository.save(book);

        System.out.println("\n>>> Livro salvo com sucesso! <<<\n");
        System.out.println(book);
    }

    public void listAllBooks() {
        List<Book> books = repository.findAll();
        books.forEach(System.out::println);
    }

    public void  findBooksByLanguage(String language) {
        List<Book> books = repository.findByLanguagesCode(language);
        if (books.isEmpty()) {
            System.out.println("\nNenhum livro encontrado para o idioma: " + language);
        } else {
            System.out.println("\n--------------------------------------------------\n");
            System.out.println("\nLivros encontrados para o idioma " + language + ":\n");
            books.forEach(System.out::println);
        }
    }
}