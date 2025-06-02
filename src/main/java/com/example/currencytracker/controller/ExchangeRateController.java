package com.example.currencytracker.controller;

import com.example.currencytracker.dto.ExchangeRateResponse;
import com.example.currencytracker.service.ExchangeRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService){
        this.exchangeRateService=exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<ExchangeRateResponse> getCurrencyExchangeRate(@RequestParam String base, @RequestParam String target){
        ExchangeRateResponse response = exchangeRateService.currentExchangeRate(base, target);
        return ResponseEntity.ok(response);
    }
}
