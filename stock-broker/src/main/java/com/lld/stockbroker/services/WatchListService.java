package com.lld.stockbroker.services;

import com.lld.stockbroker.Stock.Stock;
import com.lld.stockbroker.models.MarketDataObserver;
import com.lld.stockbroker.models.StockPriceUpdateEvent;
import com.lld.stockbroker.models.WatchList;

import java.util.List;
import java.util.Map;

public class WatchListService implements MarketDataObserver {
    Map<String, WatchList> watchListCache;

    @Override
    public void onStockPriceUpdateEvent(StockPriceUpdateEvent stockPriceUpdateEvent) {
        for(Map.Entry<String,WatchList> entry : watchListCache.entrySet()){
            WatchList watchList = entry.getValue();
            List<Stock> stocks = watchList.getStocks();
            for(Stock stock : stocks){
                if(stock.getStockSymbol().equals(stockPriceUpdateEvent.getSymbol())){
                    stock.setCurrentPrice(stockPriceUpdateEvent.getCurrentPrice());
                }
            }
            watchList.setStocks(stocks);
            entry.setValue(watchList);
        }
    }
}
