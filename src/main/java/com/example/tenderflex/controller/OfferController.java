package com.example.tenderflex.controller;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    public final OfferService offerService;
@Autowired
    public OfferController (OfferService offerService)
    {
        this.offerService=offerService;
    }

    @GetMapping("/me")
    public ResponseEntity <List<Offer>> getAllOffers(@RequestParam( required = false,name = "count") Integer count,
                                                      @RequestParam(required = true,name = "page") Integer page) {
    List <Offer> offers = offerService.getOffersByCurrentUser(new Paging(count,page));
    if (offers.isEmpty()) {
        return new ResponseEntity<>(null,HttpStatusCode.valueOf(404));
    }
    return new ResponseEntity<>(offers,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Offer> getOfferByOfferId (@PathVariable(value = "id") Long offer_id) {
        Offer offer = offerService.getOfferByOfferId(offer_id);
        if (offer == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(offer, HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public void createOffer(@RequestBody Offer offer) {
        offerService.createOffer(offer);
    }

}
