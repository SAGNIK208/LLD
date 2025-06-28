package com.lld.atm.ATMState;

import com.lld.atm.ATM;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

public class ReadyState implements ATMState{
    private ATM atm;

    public ReadyState(ATM atm){
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
        switch (operationType){
            case CHECK_BALANCE:
                this.atm.nextState(new VerifyingBalanceState(this.atm));
                break;
            case WITHDRAW:
                this.atm.nextState(new WithdrawingState(this.atm));
                break;
        }
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectCard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ATMStates getState() {
        return ATMStates.READY;
    }
}
