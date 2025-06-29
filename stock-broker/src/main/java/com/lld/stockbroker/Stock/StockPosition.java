package com.lld.stockbroker.Stock;

import java.math.BigDecimal;
import java.util.UUID;

public class StockPosition {
    private final String stockSymbol;
    private int quantity;
    private BigDecimal averageBuyPrice;

    public StockPosition(String stockSymbol,int quantity,BigDecimal averageBuyPrice){
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.averageBuyPrice = averageBuyPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getAverageBuyPrice() {
        return averageBuyPrice;
    }

    public void setAverageBuyPrice(BigDecimal averageBuyPrice) {
        this.averageBuyPrice = averageBuyPrice;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockPosition{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", quantity=" + quantity +
                ", averageBuyPrice=" + averageBuyPrice.intValue() +
                '}';
    }
}
