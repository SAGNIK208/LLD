package com.lld.atm.ATMState;

import com.lld.atm.ATM;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;
import com.lld.atm.services.AuthenticateManager;

public class AuthenticatingState implements ATMState {

    private ATM atm;

    public AuthenticatingState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void authenticate(String pin) {
        boolean isSuccess = AuthenticateManager.authenticateCard(this.atm.getCurrentCard(), pin);
        if(isSuccess){
            this.atm.nextState(new ReadyState(this.atm));
        }else{
            this.atm.nextState(new ExitState(this.atm));
        }
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectCard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ATMStates getState() {
        return ATMStates.AUTHENTICATING;
    }
}
