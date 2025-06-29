package com.lld.stockbroker.services;

import com.lld.stockbroker.Order.Order;
import com.lld.stockbroker.Stock.Portfolio;
import com.lld.stockbroker.Stock.StockPosition;
import com.lld.stockbroker.models.MarketDataObserver;
import com.lld.stockbroker.models.StockPriceUpdateEvent;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class PortfolioManagementService implements MarketDataObserver {
    private final Map<String, Portfolio> portfolioCache;
    private final MarketDataService marketDataService;
    public PortfolioManagementService(MarketDataService marketDataService){
        this.portfolioCache = new HashMap<>();
        this.marketDataService = marketDataService;
    }
    public void updatePortfolio(Order order){
        String accountId = order.getAccountId();
        Portfolio portfolio = portfolioCache.getOrDefault(accountId,new Portfolio(accountId));
        StockPosition position = portfolio.getStockPositions().getOrDefault(order.getStockSymbol(),
                new StockPosition(order.getStockSymbol(),0,BigDecimal.ZERO));
        BigDecimal oldBuyAvg = position.getAverageBuyPrice()
                .multiply(BigDecimal.valueOf(position.getQuantity()));
        int newQuantity = position.getQuantity() + order.getQuantity();
        BigDecimal currentBuyPrice = marketDataService
                .getStockBySymbol(order.getStockSymbol()).getCurrentPrice();
        currentBuyPrice = currentBuyPrice.multiply(BigDecimal.valueOf(order.getQuantity()));
        position.setAverageBuyPrice(currentBuyPrice.add(oldBuyAvg).divide(BigDecimal.valueOf(newQuantity), MathContext.DECIMAL64));
        position.setQuantity(newQuantity);
        portfolio.updateStockPosition(order.getStockSymbol(),position);
        portfolioCache.put(accountId,portfolio);
    }

    public Map<String,StockPosition> getStockPositions(String accountId){
        return this.portfolioCache.get(accountId).getStockPositions();
    }

    @Override
    public void onStockPriceUpdateEvent(StockPriceUpdateEvent stockPriceUpdateEvent) {
        // Calculate portfolio current values and might trigger notifications
    }



    @Override
    public String toString() {
        return "PortfolioManagementService{" +
                "portfolioCache=" + portfolioCache.keySet() + "-------------" + portfolioCache.values() +
                '}';
    }
}
