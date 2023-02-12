package com.example.tenderflex.model;


public class Offer {

    public Offer(int id, String name, String officialName, String natRegNumber, String townCity, String contPersonName,
                 String contPersonSurname, String phoneNumber, int bidPrice, Long userId, Long tenderId, OfferStatus offerStatus,
                 Long offerDate,
                 String offerFileKey) {
        this.id = id;
        this.name = name;
        this.officialName = officialName;
        this.natRegNumber = natRegNumber;
        this.townCity = townCity;
        this.contPersonName = contPersonName;
        this.contPersonSurname = contPersonSurname;
        this.phoneNumber = phoneNumber;
        this.bidPrice = bidPrice;
        this.userId = userId;
        this.tenderId = tenderId;
        this.offerStatus = offerStatus;
        this.offerFileKey = offerFileKey;
        this.offerDate = offerDate;
    }

    private int id;
    private String name;
    private String officialName;
    private String natRegNumber;
    private String townCity;
    private String contPersonName;
    private String contPersonSurname;
    private String phoneNumber;
    private int bidPrice;
    private Long userId;
    private Long tenderId;
    private OfferStatus offerStatus;
    private Long offerDate;
    private String offerFileKey;

    public Long getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Long offerDate) {
        this.offerDate = offerDate;
    }

    public String getOfferFileKey() {
        return offerFileKey;
    }

    public void setOfferFileKey(String offerFileKey) {
        this.offerFileKey = offerFileKey;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public String getOfficialName() {return officialName;}

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public Long getTenderId() {
        return tenderId;
    }

    public void setTenderId(Long tenderId) {
        this.tenderId = tenderId;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNatRegNumber() {return natRegNumber;}

    public void setNatRegNumber(String natRegNumber) {this.natRegNumber = natRegNumber;}

    public String getTownCity() {return townCity;}

    public void setTownCity(String townCity) {this.townCity = townCity;}

    public String getContPersonName() {return contPersonName;}

    public void setContPersonName(String contPersonName) {this.contPersonName = contPersonName;}

    public String getContPersonSurname() {return contPersonSurname;}

    public void setContPersonSurname(String contPersonSurname) {this.contPersonSurname = contPersonSurname;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public int getBidPrice() {return bidPrice;}

    public void setBidPrice(int bidPrice) {this.bidPrice = bidPrice;}
}