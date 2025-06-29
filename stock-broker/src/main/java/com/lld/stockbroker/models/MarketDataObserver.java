package com.lld.stockbroker.models;

public interface MarketDataObserver {
    void onStockPriceUpdateEvent(StockPriceUpdateEvent stockPriceUpdateEvent);
}
