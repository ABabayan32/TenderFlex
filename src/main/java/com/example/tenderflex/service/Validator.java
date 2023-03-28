package com.example.tenderflex.service;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Tender;

public interface Validator {

    boolean validate(Tender tender);

    boolean validate(Offer offer);

}
