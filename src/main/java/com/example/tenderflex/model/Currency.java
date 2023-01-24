package com.example.tenderflex.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Currency {

    private String name;
    private int currencyId;

    public String getName() {return name;}

    public int getCurrencyId() {return currencyId;}

    public void setCurrencyId(int currencyId) {this.currencyId = currencyId;}

    public void setName(String name) {this.name = name;}
}

