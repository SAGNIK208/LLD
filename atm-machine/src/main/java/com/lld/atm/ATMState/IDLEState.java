package com.lld.atm.ATMState;

import com.lld.atm.ATM;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

public class IDLEState implements ATMState{
    private final ATM atm;

    public IDLEState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        this.atm.updateCurrentCard(card);
        this.atm.nextState(new AuthenticatingState(this.atm));
    }

    @Override
    public void authenticate(String pin) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void selectTransaction(OperationType operationType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double viewBalance() {
       throw new UnsupportedOperationException();
    }

    @Override
    public Cash withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancelTransaction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectCard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ATMStates getState() {
        return ATMStates.IDLE;
    }
}
