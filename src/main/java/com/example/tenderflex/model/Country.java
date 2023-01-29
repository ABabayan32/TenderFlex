package com.example.tenderflex.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Country {
     private String name;
     private int countryId;

    public int getCountryId() {return countryId;}

    public void setCountryId(int countryId) {this.countryId = countryId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }
}
