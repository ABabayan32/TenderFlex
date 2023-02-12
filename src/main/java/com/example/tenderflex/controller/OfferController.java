package com.example.tenderflex.controller;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
@Autowired
    public OfferController (OfferService offerService)
    {
        this.offerService=offerService;
    }

    @GetMapping("/me")
    public ResponseEntity <List<Offer>> getAllOffers(@RequestParam( required = false,name = "count") Integer count,
                                                      @RequestParam(required = true,name = "page") Integer page) {
    List <Offer> offers = offerService.getOffersByCurrentUser(new Paging(count,page));
    return new ResponseEntity<>(offers,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/me/count")
    public ResponseEntity <Integer> getAllOffers() {
        return new ResponseEntity<>(offerService.getOffersCountByCurrentUser(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Offer> getOfferByOfferId (@PathVariable(value = "id") Long offerId) {
        Offer offer = offerService.getOfferByOfferId(offerId);
        if (offer == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(offer, HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}/decisionFileKey")
    public ResponseEntity <String> getFileKeysByOfferId (@PathVariable(value = "id") Long offerId) {
        String fileKey = offerService.getFileKeyByOfferId(offerId);
        if (fileKey == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(403));
        }
        return new ResponseEntity<>(fileKey, HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public void createOffer(@RequestBody Offer offer) {
        offerService.createOffer(offer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateOffer(@PathVariable(value = "id") Long id, @RequestBody Map<String,Long> status) {
        if(offerService.changeOfferStatus(id, status.get("statusId"))){
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(403));
    }

}
