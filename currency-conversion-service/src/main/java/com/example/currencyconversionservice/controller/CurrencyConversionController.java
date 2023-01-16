package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.feignConfig.CurrencyExchangeProxy;
import com.example.currencyconversionservice.model.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.getExchangeValue(from, to);

        return currencyConversion;
    }
}
