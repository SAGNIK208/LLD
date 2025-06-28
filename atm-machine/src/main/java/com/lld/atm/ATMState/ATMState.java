package com.lld.atm.ATMState;

import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

public interface ATMState {
    void insertCard(Card card);
    void authenticate(String pin);
    void selectTransaction(OperationType operationType);
    double viewBalance();
    Cash withdraw(int amount);
    void cancelTransaction();
    void ejectCard();
    ATMStates getState();
}
