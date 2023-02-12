package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Type;
import com.example.tenderflex.repository.TypeRepository;
import com.example.tenderflex.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl (TypeRepository typeRepository){
        this.typeRepository=typeRepository;
    }

    @Override
    public List<Type> getAllTypies() {
        return typeRepository.getAllTypies();
    }
}
