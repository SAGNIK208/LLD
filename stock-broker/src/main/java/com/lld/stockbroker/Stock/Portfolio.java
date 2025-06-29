package com.lld.stockbroker.Stock;

import com.lld.stockbroker.services.MarketDataService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final String accountId;
    private Map<String,StockPosition> stockPositions;

    public Portfolio(String accountId){
        this.accountId = accountId;
        this.stockPositions = new HashMap<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public Map<String,StockPosition> getStockPositions() {
        return stockPositions;
    }

    public void setStockPositions(Map<String,StockPosition> stockPositions) {
        this.stockPositions = stockPositions;
    }

    public void updateStockPosition(String symbol,StockPosition stockPosition){
        this.stockPositions.put(symbol,stockPosition);
    }

    public BigDecimal currentValue(MarketDataService marketDataService){
        BigDecimal currentValue = BigDecimal.ZERO;
        for(Map.Entry<String,StockPosition> entry : stockPositions.entrySet()){
            String stockSymbol = entry.getKey();
            Stock stock = marketDataService.getStockCache().get(stockSymbol);
            int quantity = entry.getValue().getQuantity();
            BigDecimal price = stock.getCurrentPrice();
            currentValue = currentValue.add(price.multiply(BigDecimal.valueOf(quantity)));
        }
        return currentValue;
    }
}
