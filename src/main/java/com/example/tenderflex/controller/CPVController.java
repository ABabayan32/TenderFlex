package com.example.tenderflex.controller;

import com.example.tenderflex.model.CPV;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.Type;
import com.example.tenderflex.service.CPVService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpvs")
public class CPVController {
    public final CPVService cpvService;

    public CPVController(CPVService cpvService) {
        this.cpvService = cpvService;
    }

    @GetMapping
    public ResponseEntity<List<CPV>> getAllCPVs(@RequestParam(required = false, value = "name") String cpvName) {
        if(cpvName == null){
            List<CPV> allCPVs = cpvService.getAllCPVs();
            return new ResponseEntity<>(allCPVs, HttpStatusCode.valueOf(200));
        }
        List<CPV> cpv  = cpvService.getCPVByName(cpvName);
        return new ResponseEntity<>(cpv, HttpStatusCode.valueOf(200));

    }
}