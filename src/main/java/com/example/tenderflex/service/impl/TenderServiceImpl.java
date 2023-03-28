package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.TenderStatus;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.TenderRepository;
import com.example.tenderflex.service.TenderService;
import com.example.tenderflex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.example.tenderflex.util.Constants.ROLE_BIDDER;

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
        List<Tender> tenders = tenderRepository.getTendersByUserId(user.getUserId(), paging);
        removeDecisionsFilesIfNotApplicable(tenders);
        return tenders;
    }

    @Override
    public Integer getTendersCountByUser()   {
        User user = userService.getCurrentUser();
        return tenderRepository.getTendersCountByUserId(user.getUserId());
    }

     public void addTender (Tender tender ) {
          User user= userService.getCurrentUser();
          tender.setUserId(user.getUserId());
          tender.setTenderStatus(new TenderStatus(1L, null));
          tenderRepository.createTender(tender);
    }

    @Override
    public List<Tender> getAllTenders(Paging paging) {
        List<Tender> tenders = tenderRepository.getAllTenders(paging);
        removeDecisionsFilesIfNotApplicable(tenders);
        return tenders;
    }

    @Override
    public Integer getAllTendersCount() {
        return tenderRepository.getAllTendersCount();
    }

    @Override
    public Tender getTenderByTenderId(Long tenderId, boolean isWithFileKey) {
       Tender tender = tenderRepository.getTenderByTenderId(tenderId);
       if(tender != null && !isWithFileKey) {
           removeDecisionsFilesIfNotApplicable(Collections.singletonList(tender));
       }
        return tender;
    }

    @Override
    public void updateTenderStatus(Long tenderId) {
       tenderRepository.updateTenderStatus(tenderId);

    }

    private void removeDecisionsFilesIfNotApplicable(List<Tender> tenders){
       User currentUser = userService.getCurrentUser();
        tenders.forEach(tender->{
            if(currentUser.getRole().getName().equals(ROLE_BIDDER)){
                tender.setAwardFileKey(null);
                tender.setDeclineFileKey(null);
            }
        });
    }

}
