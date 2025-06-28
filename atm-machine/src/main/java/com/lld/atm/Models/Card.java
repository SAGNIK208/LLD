package com.lld.atm.Models;

import java.util.UUID;

public class Card {
    private final String ID;
    private final String pin;

    public Card(String pin){
        this.ID = UUID.randomUUID().toString();
        this.pin = pin;
    }

    public String getID() {
        return ID;
    }

    public String getPin() {
        return pin;
    }
}
