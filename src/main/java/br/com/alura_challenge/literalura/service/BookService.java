package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.dto.BookData;
import br.com.alura_challenge.literalura.dto.BookResultsData;
import br.com.alura_challenge.literalura.mapper.BookMapper;
import br.com.alura_challenge.literalura.model.Book;
import br.com.alura_challenge.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final GutendexApiHelper helper;
    private final BookRepository repository;

    public BookService(GutendexApiHelper helper, BookRepository repository) {
        this.helper = helper;
        this.repository = repository;
    }

    private BookData getBookData(String bookName) {
        String url = helper.getEndereco() + "search=" + bookName.replace(" ", "+");
        var json = helper.getApi().getData(url);
        BookResultsData resultsData = helper.getConvertData().getData(json, BookResultsData.class);

        if (resultsData.results().isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado para: " + bookName);

        }

        return resultsData.results().get(0);
    }

    public void searchBooksWeb(String bookName) {
        BookData bookData = getBookData(bookName);
        Book book = BookMapper.toEntity(bookData);
        repository.save(book);
        System.out.println(book);
    }

    public void listAllBooks() {
        List<Book> books = repository.findAll();
        books.forEach(System.out::println);
    }
}