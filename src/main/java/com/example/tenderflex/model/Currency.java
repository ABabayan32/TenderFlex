package com.example.tenderflex.model;


public class Currency {

    public Currency(String name, int currencyId) {
        this.name = name;
        this.currencyId = currencyId;
    }

    private String name;
    private int currencyId;

    public String getName() {return name;}

    public int getCurrencyId() {return currencyId;}

    public void setCurrencyId(int currencyId) {this.currencyId = currencyId;}

    public void setName(String name) {this.name = name;}
}

