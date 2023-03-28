package com.example.tenderflex.controller;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.OfferStatus;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.OfferRepository;
import com.example.tenderflex.service.OfferService;
import com.example.tenderflex.service.TenderService;
import com.example.tenderflex.service.UserService;
import com.example.tenderflex.service.impl.OfferServiceImpl;
import com.example.tenderflex.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class OfferSeviceTest {
    OfferRepository offerRepository =mock(OfferRepository.class);
    TenderService tenderService=mock(TenderService.class);
    UserService userService = mock(UserServiceImpl.class);
    OfferService offerService=new OfferServiceImpl(offerRepository,tenderService,userService);

    @Test
    void getOffersByTenderIdTest() {
        when(userService.getCurrentUser()).thenReturn(new User(1L,null,
                "Test",null));
        Tender tender = new Tender();
        tender.setUserId(1L);
        when(tenderService.getTenderByTenderId(1L, true)).thenReturn(tender);
        Offer offer = new Offer();
        offer.setId(1000);
        when(offerRepository.getOffersByTenderId(1L, 1L))
                .thenReturn(Collections.singletonList(offer));
        assertEquals("wrong response", 1000, offerService.getOffersByTenderId(1L).get(0).getId());
    }
    @Test
   void  getFileKeyByOfferIdTest(){
        when(userService.getCurrentUser()).thenReturn(new User(5L,null,
                "Test",null));
        Offer offer=new Offer();
        offer.setId(1);
        offer.setUserId(5L);
        offer.setTenderId(2L);
        Offer offerDeclined=new Offer();
        offerDeclined.setId(2);
        offerDeclined.setUserId(5L);
        offerDeclined.setTenderId(2L);
        Tender tender=new Tender();
        tender.setId(2L);
        tender.setAwardFileKey("awardFileKey");
        tender.setDeclineFileKey("declineFileKey");
        offer.setOfferStatus(new OfferStatus(2L,null,null));
        offerDeclined.setOfferStatus(new OfferStatus(5L,null,null));
        when(offerRepository.getOfferByOfferIdForBidder(5L, 1L))
                .thenReturn(offer);
        when(offerRepository.getOfferByOfferIdForBidder(5L, 2L))
                .thenReturn(offerDeclined);
        when(tenderService.getTenderByTenderId(2L, true)).thenReturn(tender);
        assertEquals("wrong response","awardFileKey",offerService.getFileKeyByOfferId(1L));
        assertEquals("wrong response","declineFileKey",offerService.getFileKeyByOfferId(2L));
    }
}
