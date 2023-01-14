package com.example.microservices.limitsservice.controller;

import com.example.microservices.limitsservice.bean.Limits;
import com.example.microservices.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/limits")
public class LimitsController {

    private Configuration configuration;

    private LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("")
    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }


}
