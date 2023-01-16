package com.example.currencyconversionservice.feignConfig;

import com.example.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "localhost:8000") // without loadbalancing
@FeignClient(name = "currency-exchange") // with loadbalancing
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);
}
