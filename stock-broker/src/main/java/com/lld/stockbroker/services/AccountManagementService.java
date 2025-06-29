package com.lld.stockbroker.services;

import com.lld.stockbroker.Account.Account;
import com.lld.stockbroker.Account.AccountType;
import com.lld.stockbroker.Account.InvestorAccount;
import com.lld.stockbroker.Order.Order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountManagementService {
    private final Map<String,Account> accountCache;
    private final MarketDataService marketDataService;
    public AccountManagementService(MarketDataService marketDataService){
        this.marketDataService = marketDataService;
        this.accountCache = new HashMap<>();
    }
    public Account createAccount(AccountType accountType){
        Account account = null;
        switch (accountType){
            case INVESTOR:
                account = new InvestorAccount(BigDecimal.valueOf(100000));
                accountCache.put(account.getID(),account);
                break;
        }
        return account;
    }
    public Account getAccountById(String id){
        return accountCache.get(id);
    }


    public void updateAccount(Order order){
        Account account = accountCache.get(order.getAccountId());
        BigDecimal purchasePrice = marketDataService.getStockBySymbol(order.getStockSymbol()).getCurrentPrice();
        account.setCashBalance(account.getCashBalance().subtract(purchasePrice));
        accountCache.put(account.getID(),account);
    }

    @Override
    public String toString() {
        return "AccountManagementService{" +
                "accountCache=" + accountCache.keySet() + "-----------------" + accountCache.values() + '}';
    }
}
