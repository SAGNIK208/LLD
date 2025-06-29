package com.lld.stockbroker.models;

public interface MarketDataSubject {
    void registerObserver(MarketDataObserver observer);
    void unregisterObserver(MarketDataObserver observer);
    void notifyObservers(StockPriceUpdateEvent stockPriceUpdateEvent);
}
