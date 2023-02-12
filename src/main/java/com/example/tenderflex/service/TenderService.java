package com.example.tenderflex.service;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;

import java.util.List;

public interface TenderService {


     List<Tender> getTendersByUser(Paging paging)  ;
     Integer getTendersCountByUser()  ;
     void addTender (Tender tender) ;
     List <Tender> getAllTenders (Paging paging);
     Integer getAllTendersCount ();
     Tender getTenderByTenderId (Long tenderId);


}
