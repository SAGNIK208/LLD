package com.lld.atm.Models;

public enum Denominations {
    TWO_THOUSAND(2000),
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5);

    private final int value;

    Denominations(int value){
        this.value = value;
    }

    public int getValue(){
        return  this.value;
    }

}
