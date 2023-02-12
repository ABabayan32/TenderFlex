package com.example.tenderflex.controller;

import com.example.tenderflex.model.Type;
import com.example.tenderflex.service.TypeService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {
     private final TypeService typeService;
     public TypeController(TypeService typeService) {
         this.typeService=typeService;
     }
     @GetMapping()
     public ResponseEntity<List<Type>> getAllTypies() {
         List <Type>  allTypies = typeService.getAllTypies();
         return new ResponseEntity<>(allTypies, HttpStatusCode.valueOf(200));
     }
}
