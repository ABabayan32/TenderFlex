package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.Currency;
import com.example.tenderflex.repository.CurrencyRepository;
import com.example.tenderflex.repository.mapper.CurrencyMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {
    private final JdbcTemplate jdbcTemplate;

    public CurrencyRepositoryImpl (JdbcTemplate jdbcTemplate ) {  this.jdbcTemplate= jdbcTemplate;}

    @Override
    public List<Currency> getAllCurrencies() {
        return jdbcTemplate.query("SELECT * FROM tender_flex.currency",new CurrencyMapper()) ;
    }
}
