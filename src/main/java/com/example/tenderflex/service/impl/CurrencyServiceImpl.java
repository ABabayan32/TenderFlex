package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Currency;
import com.example.tenderflex.repository.CurrencyRepository;
import com.example.tenderflex.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl (CurrencyRepository currencyRepository) {
        this.currencyRepository=currencyRepository;
    }
    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.getAllCurrencies();
    }
}
