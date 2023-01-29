package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.Country;
import com.example.tenderflex.repository.CountryRepository;
import com.example.tenderflex.repository.mapper.CountryMapper;
import com.example.tenderflex.repository.mapper.TenderMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CountryRepositoryImpl implements CountryRepository {

    public final JdbcTemplate jdbcTemplate;

    public CountryRepositoryImpl (JdbcTemplate jdbcTemplate ) {  this.jdbcTemplate= jdbcTemplate;}

    public List<Country> getAllCountries () {

       return jdbcTemplate.query("SELECT * FROM tender_flex.country ", new CountryMapper()) ;
    }
}
