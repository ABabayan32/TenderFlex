package com.example.tenderflex.service;

import com.example.tenderflex.model.CPV;

import java.util.List;

public interface CPVService {
     List<CPV> getAllCPVs();
     List<CPV> getCPVByName(String cpvName);
}
