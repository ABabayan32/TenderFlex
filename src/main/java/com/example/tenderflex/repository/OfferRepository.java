package com.example.tenderflex.repository;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Offer;

import java.util.List;

public interface OfferRepository {
    List<Offer> getOffersByTenderId(Long tenderId, Long userId);
    Offer getOfferByTenderId(Long tenderId, Long userId);
    List<Offer> getAllOffers(Long userId,Paging paging);
    Integer getAllOffersCount(Long userId);
    Offer getOfferByOfferIdForContractor(Long userId, Long offerId);
    Offer getOfferByOfferIdForBidder(Long userId, Long offerId);
    void createOffer(Offer offer);
    List<Offer> getOffersByTenders(Long userId, Paging page);
    Integer getOffersCountByTenders(Long userId);
    Integer getOffersCountByTenderId(Long tenderId,Long userId);
    void updateOfferStatus(Long offerId, Long statusId);

}
