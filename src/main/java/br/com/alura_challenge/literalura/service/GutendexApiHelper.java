package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.util.ConsumptionApi;
import br.com.alura_challenge.literalura.util.ConvertData;
import org.springframework.stereotype.Component;

@Component
public class GutendexApiHelper {
    private final ConsumptionApi api;
    private final ConvertData convertData;
    private final String ENDERECO = "https://gutendex.com/books/?";

    public GutendexApiHelper(ConsumptionApi api,
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