package com.lld.stockbroker.Account;

import java.math.BigDecimal;

public class InvestorAccount extends Account{
    public InvestorAccount(BigDecimal cashBalance) {
        super(cashBalance);
        this.accountType = AccountType.INVESTOR;
    }
}
