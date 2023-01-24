package com.example.tenderflex.controller;


import com.example.tenderflex.model.Country;
import com.example.tenderflex.model.Currency;
import com.example.tenderflex.service.CurrencyService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
     public final CurrencyService currencyService;

     public CurrencyController (CurrencyService currencyService) {
         this.currencyService=currencyService;
     }
    @GetMapping
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List <Currency>  allCurrencies = currencyService.getAllCurrencies();
        return new ResponseEntity<>(allCurrencies, HttpStatusCode.valueOf(200));
    }
}
