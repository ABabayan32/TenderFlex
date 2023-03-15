package com.example.tenderflex.model;


public class CPV {

    public CPV(String name,String field, long id) {
        this.name = name;
        this.id = id;
        this.field=field;
    }

    private String name;
    private long id;
    private String field;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public long getId() {return id;}

    public void setId(int id) {this.id = id;}
    public String getField() {return field;}
    public void setField(String field) {this.field = field;}

}
