package com.lld.atm.services;

import com.lld.atm.Models.Cash;
import com.lld.atm.Models.Denominations;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    public void isCashAvailable(){

    }
    public Cash dispenseCash(int amount){
        Map<Denominations,Integer> cashNotes = new HashMap<Denominations,Integer>();
        cashNotes.put(Denominations.FIFTY,10);
        return new Cash(amount,cashNotes);
    }
}
