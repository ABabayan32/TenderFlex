package com.example.tenderflex.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Tender {

     private Long id;
     private String name;
     private Long userId;

     private String contractorName;
     private String nationalRegNumber;
     private String townCity;
     private String contactPersonName;
     private String contactPersonSurname;
     private String phoneNumber;
     private Double minValue;

    private Double maxValue;

    private Long publicDate;

    private Long deadLineOfSub;

    private Long deadForSinging;

    public Long getDeadLineOfSub() {return deadLineOfSub;}

    public void setDeadLineOfSub(Long deadLineOfSub) {
        this.deadLineOfSub=deadLineOfSub ;
    }


    public Long getDeadForSinging() {return deadForSinging;}

    public void setDeadForSinging(Long deadForSinging) {this.deadForSinging = deadForSinging;}
    public Long getPublicDate() {return publicDate;}

    public void setPublicDate(Long publicDate) {this.publicDate = publicDate;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getNationalRegNumber() {
        return nationalRegNumber;
    }

    public void setNationalRegNumber(String nationalRegNumber) {
        this.nationalRegNumber = nationalRegNumber;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonSurname() {
        return contactPersonSurname;
    }

    public void setContactPersonSurname(String contactPersonSurname) {
        this.contactPersonSurname = contactPersonSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}

