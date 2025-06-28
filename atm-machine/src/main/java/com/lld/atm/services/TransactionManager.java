package com.lld.atm.services;

import com.lld.atm.Models.Card;

public class TransactionManager {
    public double viewBalance(Card card){
        //Ideally a B.E call to Bank
        return 1_00_000;
    }

    public boolean withDraw(Card card){
        //Ideally a B.E call to Bank
        return true;
    }
}
