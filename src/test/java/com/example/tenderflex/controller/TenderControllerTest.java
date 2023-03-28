package com.example.tenderflex.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
    @AutoConfigureMockMvc
    public class TenderControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnDefaultMessage() throws Exception {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, Collections.singletonList("*"));
            httpHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,Collections.singletonList("POST"));

            this.mockMvc.perform(post("/login?username=Contractor&password=Contractor").headers(httpHeaders))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"role\":\"CONTRACTOR\"")));
        }
    }


