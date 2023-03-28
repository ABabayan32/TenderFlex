package com.example.tenderflex.repository;
import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;

import java.util.List;

public interface TenderRepository {

    List<Tender> getTendersByUserId(Long userId, Paging page);
    Integer getTendersCountByUserId(Long userId);

    void createTender (Tender tender) ;

    List <Tender> getAllTenders (Paging page) ;
    Integer getAllTendersCount() ;
     Tender getTenderByTenderId (Long tenderId);
    void updateTenderStatus( Long tender_id);

}
