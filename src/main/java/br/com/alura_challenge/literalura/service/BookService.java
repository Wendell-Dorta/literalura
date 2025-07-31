package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.dto.BookData;
import br.com.alura_challenge.literalura.dto.BookResultsData;
import br.com.alura_challenge.literalura.mapper.BookMapper;
import br.com.alura_challenge.literalura.model.Book;
import br.com.alura_challenge.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final CommonServiceHelper helper;

    public BookService(CommonServiceHelper helper) {
        this.helper = helper;
    }

    @Autowired
    private BookRepository bookRepository;

    private BookData getBookData() {
        System.out.println("Digite o nome de um livro para buscar");
        var bookName = helper.getScanner().nextLine();

        String url = helper.getEndereco() + "search=" + bookName.replace(" ", "+");
        var json = helper.getApi().getData(url);
        BookResultsData resultsData = helper.getConvertData().getData(json, BookResultsData.class);

        if (resultsData.results().isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado para: " + bookName);
        }

        BookData bookData = resultsData.results().get(0);

        return bookData;
    }

    public void searchBooksWeb() {
        BookData bookData = getBookData();
        Book book = BookMapper.toEntity(bookData);
        bookRepository.save(book);
        System.out.println(book);
    }

    public void listAllBooks() {
        List<Book> books =bookRepository.findAll();
        books.forEach(System.out::println);
    }
}