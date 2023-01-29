package com.example.tenderflex.repository;

import com.example.tenderflex.model.Currency;

import java.util.List;

public interface CurrencyRepository {
    List<Currency> getAllCurrencies();
}
