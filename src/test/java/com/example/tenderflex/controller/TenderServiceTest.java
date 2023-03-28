package com.example.tenderflex.controller;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Role;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.TenderRepository;
import com.example.tenderflex.repository.impl.TenderRepositoryImpl;
import com.example.tenderflex.service.TenderService;
import com.example.tenderflex.service.UserService;
import com.example.tenderflex.service.impl.TenderServiceImpl;
import com.example.tenderflex.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.tenderflex.util.Constants.ROLE_BIDDER;
import static com.example.tenderflex.util.Constants.ROLE_CONTRACTOR;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.*;

class TenderServiceTest {

    TenderRepository tenderRepository = mock(TenderRepositoryImpl.class);

    UserService userService = mock(UserServiceImpl.class);
     TenderService tenderService = new TenderServiceImpl(tenderRepository, userService);

     @BeforeEach
     void handleMocks(){
         Tender tender = new Tender();
         tender.setId(1L);
         tender.setDeclineFileKey("TestName");
         tender.setAwardFileKey("TestName");
         List<Tender> list = new ArrayList<>();
         list.add(tender);
         when(tenderRepository.getTenderByTenderId(any())).thenReturn(tender);
         when(tenderRepository.getTendersByUserId(any(), any())).thenReturn(list);
     }


    @Test
    void getTenderByTenderIdTest() {
        when(userService.getCurrentUser()).thenReturn(new User(1L,null,
                "Test", new Role(1L, ROLE_BIDDER)));
         assertEquals("wrong response", 1L, tenderService.getTenderByTenderId(1L, true).getId());
    }

    @Test
    void getTendersByUserTest() {
        when(userService.getCurrentUser()).thenReturn(new User(1L,null,
                "Test", new Role(1L, ROLE_BIDDER)));
         Tender tender = tenderService.getTendersByUser(new Paging(5, 0)).get(0);
        assertNull("Expected Null key for User Bidder but got value", tender.getAwardFileKey());
        assertNull("Expected Null key for User Bidder but got value", tender.getDeclineFileKey());
    }

    @Test
    void getTendersByUserContractorTest() {
        when(userService.getCurrentUser()).thenReturn(new User(2L,null,
                "Test", new Role(1L, ROLE_CONTRACTOR)));
        Tender tender = tenderService.getTendersByUser(new Paging(5, 0)).get(0);
        assertNotNull("Expected value key for User Contractor but got null", tender.getAwardFileKey());
        assertNotNull("Expected value key for User Bidder but got null", tender.getDeclineFileKey());
    }
}