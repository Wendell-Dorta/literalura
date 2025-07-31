package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.dto.BookData;
import br.com.alura_challenge.literalura.dto.BookResultsData;
import br.com.alura_challenge.literalura.mapper.BookMapper;
import br.com.alura_challenge.literalura.model.Book;
import br.com.alura_challenge.literalura.repository.BookRepository;
import br.com.alura_challenge.literalura.util.ConsumptionApi;
import br.com.alura_challenge.literalura.util.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumptionApi api;
    private final ConvertData convertData;
    private final String ENDERECO = "https://gutendex.com/books/?";

    @Autowired
    private BookRepository bookRepository;

    public BookService(ConsumptionApi api, ConvertData convertData) {
        this.api = api;
        this.convertData = convertData;
    }

    private BookData getBookData() {
        System.out.println("Digite o nome de um livro para buscar");
        var bookName = scanner.nextLine();

        String url = ENDERECO + "search=" + bookName.replace(" ", "+");
        var json = api.getData(url);
        BookResultsData resultsData = convertData.getData(json, BookResultsData.class);

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
}
