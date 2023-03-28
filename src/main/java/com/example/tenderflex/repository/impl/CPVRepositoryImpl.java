package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.CPV;
import com.example.tenderflex.repository.CPVRepository;
import com.example.tenderflex.repository.mapper.CPVMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@Repository
public class CPVRepositoryImpl implements CPVRepository {

    private final JdbcTemplate jdbcTemplate;

    public CPVRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<CPV> getAllCPVs() {
        return jdbcTemplate.query("SELECT*FROM tender_flex.cpv", new CPVMapper());
    }

    @Override
    public List<CPV> getCPVByName(String cpvName) {
        return jdbcTemplate.query("SELECT * FROM tender_flex.cpv WHERE  \"cpv_name\" like ?;" ,new CPVMapper(), "%"+cpvName+"%");
    }
}
