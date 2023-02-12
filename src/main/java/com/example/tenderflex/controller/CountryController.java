package com.example.tenderflex.controller;

import com.example.tenderflex.model.Country;
import com.example.tenderflex.service.CountryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
     private final CountryService countryService;

     public CountryController (CountryService countryService) {
         this.countryService=countryService ;}
    @GetMapping()
    public ResponseEntity<List<Country>> getAllCountries() {
       List <Country>  allCountries = countryService.getAllCountries();
       return new ResponseEntity<>(allCountries, HttpStatusCode.valueOf(200));
    }



}
