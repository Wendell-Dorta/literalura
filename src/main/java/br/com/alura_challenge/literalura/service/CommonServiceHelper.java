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
    private final ConsumptionApi api;
    private final ConvertData convertData;
    private final String ENDERECO = "https://gutendex.com/books/?";

    public CommonServiceHelper(ConsumptionApi api,
                               ConvertData convertData) {
        this.api = api;
        this.convertData = convertData;
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
}