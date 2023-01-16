package com.example.currencyconversionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/currency-conversion/welcome")
    public String welcome(){
        return "Welcome to Currency Conversion Service";
    }
}
