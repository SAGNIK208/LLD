package com.lld.atm.Models;

import java.util.List;
import java.util.Map;

public class Cash {
    private int amount;
    private Map<Denominations,Integer> denominationsList;
    public Cash(int amount,Map<Denominations,Integer>denominationsList){
        this.amount = amount;
        this.denominationsList = denominationsList;
    }
}
