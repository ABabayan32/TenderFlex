package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.CPV;
import com.example.tenderflex.repository.CPVRepository;
import com.example.tenderflex.service.CPVService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPVServiceImpl implements CPVService {

    private final CPVRepository cpvRepository;
    public CPVServiceImpl (CPVRepository cpvRepository) {
        this.cpvRepository=cpvRepository;
    }

    @Override
    public List<CPV> getAllCPVs() {
        return cpvRepository.getAllCPVs();
    }

    @Override
    public List<CPV> getCPVByName(String cpvName) {
        return cpvRepository.getCPVByName( cpvName);
    }
}
