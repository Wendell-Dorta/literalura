package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.repository.AuthorRepository;
import br.com.alura_challenge.literalura.repository.BookRepository;
import br.com.alura_challenge.literalura.repository.LanguageRepository;
import br.com.alura_challenge.literalura.util.ConsumptionApi;
import br.com.alura_challenge.literalura.util.ConvertData;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommonServiceHelper {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumptionApi api;
    private final ConvertData convertData;
    private final String ENDERECO = "https://gutendex.com/books/?";
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;
    private final BookRepository bookRepository;

    public CommonServiceHelper(ConsumptionApi api,
                               ConvertData convertData,
                               BookRepository bookRepository,
                               LanguageRepository languageRepository,
                               AuthorRepository authorRepository) {
        this.api = api;
        this.convertData = convertData;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ConsumptionApi getApi() {
        return api;
    }

    public ConvertData getConvertData() {
        return convertData;
    }

    public String getEndereco() {
        return ENDERECO;
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public LanguageRepository getLanguageRepository() {
        return languageRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

}