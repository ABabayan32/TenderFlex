package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.TenderRepository;
import com.example.tenderflex.service.TenderService;
import com.example.tenderflex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenderServiceImpl implements TenderService {

   private final TenderRepository tenderRepository;
   private final UserService userService;

   @Autowired
   public TenderServiceImpl (TenderRepository tenderRepository, UserService userService) {
       this.tenderRepository=tenderRepository ;
       this.userService = userService;

   }

    @Override
    public List<Tender> getTendersByUser(Paging paging)   {
       User user = userService.getCurrentUser();
        return tenderRepository.getTendersByUserId(user.getUserId(), paging);
    }

     public void addTender (Tender tender ) {
          User user= userService.getCurrentUser();
          tender.setUserId(user.getUserId());
          tenderRepository.createTender(tender);
    }

    @Override
    public List<Tender> getAllTenders(Paging paging) {

        return tenderRepository.getAllTenders(paging);
    }

    @Override
    public Tender getTenderByTenderId(Long tenderId) {
        return tenderRepository.getTenderByTenderId(tenderId);
    }


}
