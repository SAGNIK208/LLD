package com.lld.stockbroker.Account;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Account {
    private final String ID;
    private BigDecimal cashBalance;
    protected AccountType accountType;
    public Account(BigDecimal cashBalance){
        ID = UUID.randomUUID().toString();
        this.cashBalance = cashBalance;
    }

    public String getID() {
        return ID;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }
}
