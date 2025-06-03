package com.jiofack.currencyconverter.model;

import lombok.Data;

@Data
public class ConversionResponse {
    private String from;

    private String to;

    private double amount;

    private double rate;

    private double result;

    public ConversionResponse(String from, String to, double amount, double rate, double result) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.rate = rate;
        this.result = result;
    }
}
