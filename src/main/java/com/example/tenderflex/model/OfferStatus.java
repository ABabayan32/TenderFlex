package com.example.tenderflex.model;

public class OfferStatus {
    private Long id;
    private String nameBr;
    private String nameCt;

    public OfferStatus(Long id, String nameBr, String nameCt) {
        this.id = id;
        this.nameBr = nameBr;
        this.nameCt = nameCt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBr() {
        return nameBr;
    }

    public void setNameBr(String nameBr) {
        this.nameBr = nameBr;
    }

    public String getNameCt() {
        return nameCt;
    }

    public void setNameCt(String nameCt) {
        this.nameCt = nameCt;
    }
}
