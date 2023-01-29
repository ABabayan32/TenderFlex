package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.Type;
import com.example.tenderflex.repository.TypeRepository;
import com.example.tenderflex.repository.mapper.TypeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TypeRepositoryImpl implements TypeRepository {
    public final JdbcTemplate jdbcTemplate;

    public TypeRepositoryImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Type> getAllTypies() {
        return jdbcTemplate.query("SELECT* FROM tender_flex.type" ,new TypeMapper());
    }
}
