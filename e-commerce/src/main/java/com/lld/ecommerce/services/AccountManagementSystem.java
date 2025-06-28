package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Account.AccountType;
import com.lld.ecommerce.models.Account.PrimeAccount;

import java.util.List;

public class AccountManagementSystem {
    public Account createAccount(AccountType accountType, String username, String password, String name, List<String> address){
        Account account = null;
        switch (accountType){
            case PRIME:
                account = new PrimeAccount(name,username,password,address);
                break;
        }
        return account;
    }
}
