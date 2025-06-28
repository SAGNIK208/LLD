package com.lld.atm.ATMState;

import com.lld.atm.ATM;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

public class VerifyingBalanceState implements ATMState {
    private final ATM atm;

    public VerifyingBalanceState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        throw new UnsupportedOperationException();
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
        double balance = this.atm.getTransactionManager().viewBalance(this.atm.getCurrentCard());
        this.atm.nextState(new ExitState(this.atm));
        return balance;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public ATMStates getState() {
        return ATMStates.VERIFYING_BALANCE;
    }
}
