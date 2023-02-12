package com.example.tenderflex.service;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;

import java.util.List;

public interface OfferService {
    List<Offer> getOffersByTenderId (Long tenderId, Paging paging);
    List<Offer> getOffersByCurrentUser(Paging paging);
    Offer getOfferByOfferId (Long offerId);
    void createOffer(Offer offer);
    List<Offer> getOffersByTenders(Paging page);
}
