package com.jiofack.currencyconverter.service;

import com.jiofack.currencyconverter.exception.CurrencyConversionException;
import com.jiofack.currencyconverter.model.ConversionResponse;
import com.jiofack.currencyconverter.model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    @Value("${exchangerate.api.key}")
    private String apiKey;

    @Value("${exchangerate.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ConversionResponse convert(String from, String to, double amount){
        try {
            String url = String.format("%s/%s/latest/%s", apiUrl, apiKey, from);
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);

            if (response == null || response.getConversion_rates() == null || !response.getConversion_rates().containsKey(to)){
                throw new RuntimeException("La devise cible '" + to + "' n'est pas prise en charge.");
        }

            double rate = response.getConversion_rates().get(to);
            double result = amount * rate;

            return new ConversionResponse(from, to, amount, rate, result);
        } catch (RestClientException e) {
            throw new CurrencyConversionException("Erreur lors de la connexion à l'API externe : " + e.getMessage());
        }
    }
}
