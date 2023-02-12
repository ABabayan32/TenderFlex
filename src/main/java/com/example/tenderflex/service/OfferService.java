package com.example.tenderflex.service;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;

import java.util.List;

public interface OfferService {
    List<Offer> getOffersByTenderId (Long tenderId);
    List<Offer> getOffersByCurrentUser(Paging paging);
    Integer getOffersCountByCurrentUser();
    Offer getOfferByOfferId (Long offerId);
    void createOffer(Offer offer);
    List<Offer> getOffersByTenders(Paging page);
    Integer getOffersCountByTenders();
    String getFileKeyByOfferId(Long id);
    boolean changeOfferStatus(Long offerId, Long statusId);
}
