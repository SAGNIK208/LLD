package com.lld.ecommerce.models.Account;

import java.util.List;

public class PrimeAccount extends Account {
    public PrimeAccount(String name, String username, String password, List<String> addresses) {
        super(name, username, password, addresses);
        this.accountType = AccountType.PRIME;
    }
}
