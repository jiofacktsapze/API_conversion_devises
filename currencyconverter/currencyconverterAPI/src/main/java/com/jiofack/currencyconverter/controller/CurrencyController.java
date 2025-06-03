package com.jiofack.currencyconverter.controller;

import com.jiofack.currencyconverter.model.ConversionResponse;
import com.jiofack.currencyconverter.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Convertir une somme d'une devise à une autre")
    @GetMapping
    public ConversionResponse convert(
            @Parameter(description = "Code ISO de la devise source (ex: USD)")
            @RequestParam String from,

            @Parameter(description = "Code ISO de la devise cible (ex: XAF)")
            @RequestParam String to,

            @Parameter(description = "Montant à convertir")
            @RequestParam double amount
    ){
        return currencyService.convert(from, to, amount);
    }
}
