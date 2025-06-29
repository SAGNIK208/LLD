package com.lld.stockbroker.services;

import com.lld.stockbroker.Stock.Stock;
import com.lld.stockbroker.models.MarketDataObserver;
import com.lld.stockbroker.models.MarketDataSubject;
import com.lld.stockbroker.models.StockPriceUpdateEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketDataService  implements MarketDataSubject {

    private Map<String, Stock> stockCache;
    private List<MarketDataObserver> observers;

    public  MarketDataService(){
        stockCache = new HashMap<>();
    }

    public Map<String, Stock> getStockCache() {
        return stockCache;
    }
    public Stock getStockBySymbol(String stockSymbol){
        return this.getStockCache().get(stockSymbol);
    }

    public void setStockCache(Map<String, Stock> stockCache) {
        this.stockCache = stockCache;
    }

    public void addStock(Stock stock){
        stockCache.put(stock.getStockSymbol(),stock);
    }

    public void updateStockCache(String stockSymbol,Stock stock){
        this.stockCache.put(stockSymbol,stock);
    }

    @Override
    public void registerObserver(MarketDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(MarketDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(StockPriceUpdateEvent stockPriceUpdateEvent) {
        for(MarketDataObserver observer : observers){
            observer.onStockPriceUpdateEvent(stockPriceUpdateEvent);
        }
    }
}
