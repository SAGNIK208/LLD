package com.lld.atm.services;

import com.lld.atm.Models.Card;

public class AuthenticateManager {
    public static boolean authenticateCard(Card card,String pin){
        return card.getPin().equals(pin);
    }
}
