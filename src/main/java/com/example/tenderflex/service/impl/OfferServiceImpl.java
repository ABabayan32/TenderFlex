package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.OfferRepository;
import com.example.tenderflex.service.OfferService;
import com.example.tenderflex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferServiceImpl implements OfferService {
    public final OfferRepository offerRepository;
    public final UserService userService;
@Autowired
    public OfferServiceImpl (OfferRepository offerRepository,UserService userService) {
        this.offerRepository =offerRepository;
        this.userService=userService;
    }

    @Override
    public List<Offer> getOffersByTenderId(Long tenderId,Paging paging) {
        return offerRepository.getOffersByTenderId(tenderId,userService.getCurrentUser().getUserId(), paging);
    }

    @Override
    public List<Offer> getOffersByCurrentUser(Paging paging) {
      User user = userService.getCurrentUser();

        return offerRepository.getAllOffers(user.getUserId(), paging);
    }

    @Override
    public Offer getOfferByOfferId(Long offerId) {
        return offerRepository.getOfferByOfferId(offerId);
    }

    @Override
    public void createOffer(Offer offer) {
        User user= userService.getCurrentUser();
        offer.setUserId(user.getUserId());
        offerRepository.createOffer(offer);
    }

    @Override
    public List<Offer> getOffersByTenders(Paging page) {
        return offerRepository.getOffersByTenders(userService.getCurrentUser().getUserId(),page);
    }
}
