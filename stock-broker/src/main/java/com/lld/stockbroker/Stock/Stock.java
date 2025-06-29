package com.lld.stockbroker.Stock;

import java.math.BigDecimal;

public class Stock {
    private final String stockSymbol;
    private final String companyName;
    //We can have this as an enum
    private final String exchange;
    private BigDecimal currentPrice;

    public Stock(String stockSymbol,String companyName,String exchange,BigDecimal price){
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.currentPrice = price;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
