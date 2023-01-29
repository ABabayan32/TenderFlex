package com.example.tenderflex.controller;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.User;
import com.example.tenderflex.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenders")
public class TenderController {

    public final TenderService tenderService;
    @Autowired
    public TenderController (TenderService tenderService) {
        this.tenderService=tenderService ;
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

    @GetMapping("/me")
    @ResponseBody
    public ResponseEntity<List<Tender>> getTendersByUser(@RequestParam(required = false,name = "count") Integer count,
                                                         @RequestParam(required = true,name = "page") Integer page) {
        List<Tender> tenders = tenderService.getTendersByUser(new Paging(count, page)) ;
        return new ResponseEntity<>(tenders, HttpStatusCode.valueOf(200));
    }

     @GetMapping("/{id}")
     public ResponseEntity <Tender> getTenderByTenderId (@PathVariable(value = "id") Long tenderId) {
        Tender tender = tenderService.getTenderByTenderId(tenderId);
        if(tender == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(tender, HttpStatusCode.valueOf(200));
     }


}