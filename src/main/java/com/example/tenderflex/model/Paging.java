package com.example.tenderflex.model;

public class Paging {

    private final Integer count ;
    private final Integer index;

    public Paging(Integer count,Integer page) {
        if(count==null) {
            this.count=20;}
        else {
            this.count=count;
        }
        index = this.count * page;
    }

    public int getCount() {return count;}

    public int getIndex() {return index;}

}
