package com.example.tenderflex.repository;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;

import java.util.List;

public interface TenderRepository {

    List<Tender> getTendersByUserId(Long userId, Paging page);

    void createTender (Tender tender) ;

    List <Tender> getAllTenders (Paging page) ;
     Tender getTenderByTenderId (Long tenderId);



}
