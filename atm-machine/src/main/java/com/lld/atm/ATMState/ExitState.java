package com.lld.atm.ATMState;

import com.lld.atm.ATM;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

public class ExitState implements ATMState{
    private final ATM atm;

    public ExitState(ATM atm){
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
        this.atm.nextState(new ExitState(this.atm));
    }

    @Override
    public void ejectCard() {
        this.atm.updateCurrentCard(null);
        this.atm.nextState(new IDLEState(this.atm));
    }

    @Override
    public ATMStates getState() {
        return ATMStates.EXIT;
    }
}
