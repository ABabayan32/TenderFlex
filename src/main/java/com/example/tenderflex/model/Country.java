package com.example.tenderflex.model;


public class Country {

    public Country(String name, int countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    private String name;
     private int countryId;

    public int getCountryId() {return countryId;}

    public void setCountryId(int countryId) {this.countryId = countryId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }
}
