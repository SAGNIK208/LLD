package com.lld.stockbroker.models;

import java.math.BigDecimal;

public class StockPriceUpdateEvent {
    private final String symbol;
    private final BigDecimal currentPrice;
    private final long timestamp;
    public StockPriceUpdateEvent(String symbol,BigDecimal currentPrice){
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
