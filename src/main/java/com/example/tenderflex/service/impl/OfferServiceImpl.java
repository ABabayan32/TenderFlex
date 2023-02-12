package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.*;
import com.example.tenderflex.repository.OfferRepository;
import com.example.tenderflex.service.OfferService;
import com.example.tenderflex.service.TenderService;
import com.example.tenderflex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.example.tenderflex.util.Constants.*;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final TenderService tenderService;
    private final UserService userService;
@Autowired
    public OfferServiceImpl (OfferRepository offerRepository, TenderService tenderService, UserService userService) {
        this.offerRepository = offerRepository;
        this.tenderService = tenderService;
        this.userService = userService;
    }

    @Override
    public List<Offer> getOffersByTenderId(Long tenderId) {
    Tender tender = tenderService.getTenderByTenderId(tenderId);
    User currentUser = userService.getCurrentUser();
        if(tender.getUserId().equals(currentUser.getUserId())){
            return offerRepository.getOffersByTenderId(tenderId,userService.getCurrentUser().getUserId());
        }
        return null;
    }

    @Override
    public List<Offer> getOffersByCurrentUser(Paging paging) {
      User user = userService.getCurrentUser();

        return offerRepository.getAllOffers(user.getUserId(), paging);
    }

    @Override
    public Integer getOffersCountByCurrentUser() {
        User user = userService.getCurrentUser();

        return offerRepository.getAllOffersCount(user.getUserId());
    }

    @Override
    public Offer getOfferByOfferId(Long offerId) {
        return offerRepository.getOfferByOfferId(offerId);
    }

    @Override
    public void createOffer(Offer offer) {
        User user= userService.getCurrentUser();
        offer.setUserId(user.getUserId());
        offer.setOfferDate(new Date().getTime());
        offer.setOfferStatus(new OfferStatus(OFFER_STATUS_SENT_ID, null, null));
        offerRepository.createOffer(offer);
    }

    @Override
    public List<Offer> getOffersByTenders(Paging page) {
        return offerRepository.getOffersByTenders(userService.getCurrentUser().getUserId(),page);
    }

    @Override
    public Integer getOffersCountByTenders() {
        return offerRepository.getOffersCountByTenders(userService.getCurrentUser().getUserId());
    }

    @Override
    public String getFileKeyByOfferId(Long id) {
        Offer offer = offerRepository.getOfferByOfferId(id);
        User currentUser = userService.getCurrentUser();
        if(offer.getUserId().equals(currentUser.getUserId())){
            if(offer.getOfferStatus().getId() == OFFER_STATUS_AWARDED_CONTRACTOR_ID
                    || offer.getOfferStatus().getId() == OFFER_STATUS_APPROVED_BIDDER_ID ){
                return tenderService.getTenderByTenderId(offer.getTenderId()).getAwardFileKey();
            } else if(offer.getOfferStatus().getId() == OFFER_STATUS_DECLINED_CONTRACTOR_ID){
                return tenderService.getTenderByTenderId(offer.getTenderId()).getDeclineFileKey();
            }
        };
        return null;
    }

    @Override
    public boolean changeOfferStatus(Long offerId, Long statusId) {
        User currentUser = userService.getCurrentUser();
        Offer offer = offerRepository.getOfferByOfferId(offerId);
        if(currentUser.getUserId().equals(offer.getUserId())
        && offer.getOfferStatus().getId() == OFFER_STATUS_AWARDED_CONTRACTOR_ID
                && (statusId == OFFER_STATUS_DECLINED_BIDDER_ID || statusId == OFFER_STATUS_APPROVED_BIDDER_ID)){
                offerRepository.updateOfferStatus(offerId, statusId);
                return true;
        }
        Tender tender = tenderService.getTenderByTenderId(offer.getTenderId());
        if(tender.getUserId().equals(currentUser.getUserId())
                && offer.getOfferStatus().getId().equals(OFFER_STATUS_SENT_ID)
                && (statusId == OFFER_STATUS_AWARDED_CONTRACTOR_ID || statusId == OFFER_STATUS_DECLINED_CONTRACTOR_ID)){
            offerRepository.updateOfferStatus(offerId, statusId);
            return true;
        }
         return false;
    }
}
