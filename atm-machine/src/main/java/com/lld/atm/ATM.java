package com.lld.atm;

import com.lld.atm.ATMState.ATMState;
import com.lld.atm.ATMState.IDLEState;
import com.lld.atm.Models.Card;
import com.lld.atm.services.ATMInventory;
import com.lld.atm.services.TransactionManager;

import java.util.UUID;

public class ATM {

    private final String ID;
    private ATMState atmState;
    private final ATMInventory atmInventory;
    private final TransactionManager transactionManager;
    private static ATM INSTANCE;
    private Card currentCard;

    private ATM(){
        this.atmInventory = new ATMInventory();
        this.transactionManager = new TransactionManager();
        this.atmState = new IDLEState(this);
        ID = UUID.randomUUID().toString();
    }

    public static ATM getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ATM();
        }
        return INSTANCE;
    }

    public void updateCurrentCard(Card card){
        this.currentCard = card;
    }

    public void nextState(ATMState atmState){
        this.atmState = atmState;
    }

    public String getID() {
        return ID;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public ATMInventory getAtmInventory() {
        return atmInventory;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public Card getCurrentCard() {
        return currentCard;
    }
}
