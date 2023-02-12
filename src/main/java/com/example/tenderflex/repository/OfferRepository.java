package com.example.tenderflex.repository;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Offer;

import java.util.List;

public interface OfferRepository {
    List<Offer> getOffersByTenderId(Long tenderId, Long userId,Paging page);

    List<Offer> getAllOffers(Long userId,Paging paging);
    Offer getOfferByOfferId(Long offerId);
    void createOffer(Offer offer);
    List<Offer> getOffersByTenders(Long userId, Paging page);


}
