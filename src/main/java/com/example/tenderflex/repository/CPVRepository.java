package com.example.tenderflex.repository;

import com.example.tenderflex.model.CPV;


import java.util.List;

public interface CPVRepository {
    List<CPV> getAllCPVs();

   List <CPV> getCPVByName (String cpvName );
}
