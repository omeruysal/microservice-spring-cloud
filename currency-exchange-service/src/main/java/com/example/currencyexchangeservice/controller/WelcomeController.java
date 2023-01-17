package com.example.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    @GetMapping("/currency-exchange/welcome")
    @Retry(name = "default", fallbackMethod = "hardcodedResponse" ) // Bu endpoint icinde herhangi bir problem oldugunda default olarak 3 kez istek tekrarlanir
    //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse") // Cok fazla istek hata alinca bir yerden sonra otamatik olarak welcome methoduna gelmez ve fallback methodunu cagirir (open mode)
    // Belirli araliklarla minumum sayida istek icin welcome methodunu cagirir ve hata devam ediyor mu diye kontrol eder (half open mode)
    public String welcome() {
        System.out.println("This label will be printed 3 times because Retry default try 3 times");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);
        return forEntity.getBody();
        //return "Welcome to Currency Exchange Service";
    }

    public String hardcodedResponse(Exception ex) {
        return "Fallback response";
    }
}
