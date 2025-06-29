package com.lld.stockbroker.models;

import com.lld.stockbroker.Stock.Stock;

import java.util.List;
import java.util.UUID;

public class WatchList {
    private final String ID;
    private final String accountId;
    private List<Stock> stocks;
    public WatchList(String accountId,List<Stock> stocks){
        ID = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.stocks = stocks;
    }

    public String getID() {
        return ID;
    }

    public String getAccountId() {
        return accountId;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock){
        this.stocks.add(stock);
    }
    public void removeStock(Stock stock){
        this.stocks.remove(stock);
    }
}
