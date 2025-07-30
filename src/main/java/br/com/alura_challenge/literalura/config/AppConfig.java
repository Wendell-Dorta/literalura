package br.com.alura_challenge.literalura.config;

import br.com.alura_challenge.literalura.util.ConsumptionApi;
import br.com.alura_challenge.literalura.util.ConvertData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ConsumptionApi consumptionApi() {
        return new ConsumptionApi();
    }

    @Bean
    public ConvertData convertData() {
        return new ConvertData();
    }
}
