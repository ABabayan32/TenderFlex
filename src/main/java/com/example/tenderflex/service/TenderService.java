package com.example.tenderflex.service;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;

import java.util.List;

public interface TenderService {


     List<Tender> getTendersByUser(Paging paging)  ;

     void addTender (Tender tender) ;

     List <Tender> getAllTenders (Paging paging);
     Tender getTenderByTenderId (Long tenderId);


}
