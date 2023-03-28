package com.example.tenderflex.service.impl;

import com.example.tenderflex.model.Offer;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.service.Validator;
import org.springframework.stereotype.Service;

@Service
public class RequiredValidatorImpl implements Validator {
    @Override
    public boolean validate(Tender tender) {
        return tender.getName() != null
                && tender.getNationalRegNumber() != null
                && tender.getCountryId() != null
                && tender.getContactPersonName() != null
                && tender.getContactPersonSurname() != null
                && tender.getPhoneNumber() != null
                && tender.getCpv() != null
                && tender.getTenderTypeId() != null
                && tender.getMaxValue() != null
                && tender.getMinValue() != null
                && tender.getCurrencyId() != null
                && tender.getDeadForSinging() != null
                && tender.getDeadLineOfSub() != null
                && tender.getPublicDate() != null
                && tender.getAwardFileKey() != null
                && tender.getDeclineFileKey() != null
                && tender.getContractFileKey() != null;

    }

    @Override
    public boolean validate(Offer offer) {
        return false;
    }
}
