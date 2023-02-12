package com.example.tenderflex.model;

public class Tender {

    public Tender() {
    }

    public Tender(Long id, String name, Long userId, String contractorName, String nationalRegNumber, String townCity,
                  String contactPersonName, String contactPersonSurname, String phoneNumber, Double minValue, Double maxValue,
                  Long publicDate, Long deadLineOfSub, Long deadForSinging, TenderStatus tenderStatus, String contractFileKey,
                  String declineFileKey, String awardFileKey, Long countryId, Long cvpCodeId, Long tenderTypeId, Long currencyId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.contractorName = contractorName;
        this.nationalRegNumber = nationalRegNumber;
        this.townCity = townCity;
        this.contactPersonName = contactPersonName;
        this.contactPersonSurname = contactPersonSurname;
        this.phoneNumber = phoneNumber;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.publicDate = publicDate;
        this.deadLineOfSub = deadLineOfSub;
        this.deadForSinging = deadForSinging;
        this.tenderStatus = tenderStatus;
        this.contractFileKey = contractFileKey;
        this.declineFileKey = declineFileKey;
        this.awardFileKey = awardFileKey;
        this.countryId = countryId;
        this.cvpCodeId = cvpCodeId;
        this.tenderTypeId = tenderTypeId;
        this.currencyId = currencyId;
    }

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

    private TenderStatus tenderStatus;

    private String contractFileKey;

    private String declineFileKey;

    private String awardFileKey;

    private Long countryId;
    private Long cvpCodeId;

    private Long tenderTypeId;

    private Long currencyId;


    public Long getTenderTypeId() {
        return tenderTypeId;
    }

    public void setTenderTypeId(Long tenderTypeId) {
        this.tenderTypeId = tenderTypeId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getCvpCodeId() {
        return cvpCodeId;
    }

    public void setCvpCodeId(Long cvpCodeId) {
        this.cvpCodeId = cvpCodeId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getContractFileKey() {
        return contractFileKey;
    }

    public void setContractFileKey(String contractFileKey) {
        this.contractFileKey = contractFileKey;
    }

    public String getDeclineFileKey() {
        return declineFileKey;
    }

    public void setDeclineFileKey(String declineFileKey) {
        this.declineFileKey = declineFileKey;
    }

    public String getAwardFileKey() {
        return awardFileKey;
    }

    public void setAwardFileKey(String awardFileKey) {
        this.awardFileKey = awardFileKey;
    }

    public TenderStatus getTenderStatus() {
        return tenderStatus;
    }

    public void setTenderStatus(TenderStatus tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

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

