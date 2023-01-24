package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Country;
import com.example.tenderflex.repository.CountryRepository;
import com.example.tenderflex.repository.TenderRepository;
import com.example.tenderflex.service.CountryService;
import com.example.tenderflex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CountryServiceImpl implements CountryService {

    public final CountryRepository countryRepository;
@Autowired
    public CountryServiceImpl (CountryRepository countryRepository) {
        this.countryRepository=countryRepository;}
    @Override

    public List<Country> getAllCountries() {


        return countryRepository.getAllCountries();
    }
}
