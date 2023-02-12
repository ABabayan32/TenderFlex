package com.example.tenderflex.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Offer {

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