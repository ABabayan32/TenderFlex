package com.example.tenderflex.controller;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.service.OfferService;
import com.example.tenderflex.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenders")
public class TenderController {

    private final TenderService tenderService;
    private final OfferService offerService;
    @Autowired
    public TenderController (TenderService tenderService, OfferService offerService) {
        this.tenderService=tenderService;
        this.offerService = offerService;
    }

    @PostMapping ()
    public void addTender(@RequestBody Tender tender) {
        tenderService.addTender(tender);
    }

    @GetMapping()
    public ResponseEntity <List<Tender>> getAllTenders( @RequestParam(required = false,name = "count") Integer count,
                                                        @RequestParam(required = true,name = "page") Integer page) {
        List<Tender> allTenders =tenderService.getAllTenders(new Paging(count, page));
        return new ResponseEntity<>(allTenders,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/count")
    public ResponseEntity <Integer> getAllTenders() {
        return new ResponseEntity<>(tenderService.getAllTendersCount(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/me")
    @ResponseBody
    public ResponseEntity<List<Tender>> getTendersByUser(@RequestParam(required = false,name = "count") Integer count,
                                                         @RequestParam(required = true,name = "page") Integer page) {
        List<Tender> tenders = tenderService.getTendersByUser(new Paging(count, page)) ;
        return new ResponseEntity<>(tenders, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/me/count")
    @ResponseBody
    public ResponseEntity<Integer> getTendersByUser() {
        return new ResponseEntity<>(tenderService.getTendersCountByUser(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Tender> getTenderByTenderId (@PathVariable(value = "id") Long tenderId) {
        Tender tender = tenderService.getTenderByTenderId(tenderId);
        if(tender == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(tender, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}/offers")
    public ResponseEntity <List<Offer>> getOffersByTenderId (@PathVariable(value = "id") Long tenderId,
                                                             @RequestParam(required = false,name = "count") Integer count) {
        List <Offer > allOffers = offerService.getOffersByTenderId(tenderId);
        if(allOffers == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(403));
        }
        return new ResponseEntity<>(allOffers, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/me/offers")
    @ResponseBody
    public ResponseEntity <List<Offer>> getOffersByTenders(@RequestParam(required = false,name = "count") Integer count,
                                                           @RequestParam(required = true,name = "page") Integer page) {
        List<Offer> offers = offerService.getOffersByTenders(new Paging(count,page));
        return new ResponseEntity<>(offers,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/me/offers/count")
    @ResponseBody
    public ResponseEntity <Integer> getOffersByTenders() {
        return new ResponseEntity<>(offerService.getOffersCountByTenders(),HttpStatusCode.valueOf(200));
    }

}