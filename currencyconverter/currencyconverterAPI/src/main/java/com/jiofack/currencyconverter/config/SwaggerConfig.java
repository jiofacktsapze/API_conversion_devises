package com.jiofack.currencyconverter.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI currencyConverterAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Conversion de Devises")
                        .description("Cette API permet de convertir des montants entre différentes devises en utilisant les taux de change dynamiques.")
                        .version("1.0"));
    }
}
