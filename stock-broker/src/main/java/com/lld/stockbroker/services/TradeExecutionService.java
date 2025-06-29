package com.lld.stockbroker.services;

import com.lld.stockbroker.Order.Order;
import com.lld.stockbroker.Order.OrderType;
import com.lld.stockbroker.Trade.LimitOrderMatchStrategy;
import com.lld.stockbroker.Trade.MarketOrderMatchStrategy;
import com.lld.stockbroker.Trade.MatchStrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TradeExecutionService {
    private Map<OrderType, MatchStrategy> strategies = new HashMap<>();
    private MarketDataService marketDataService;

    public TradeExecutionService(MarketDataService marketDataService){
        strategies.put(OrderType.LIMIT_ORDER,new LimitOrderMatchStrategy());
        strategies.put(OrderType.MARKET_ORDER,new MarketOrderMatchStrategy());
        this.marketDataService = marketDataService;
    }

    public void process(Order order){
        BigDecimal currentMarketPrice = marketDataService.getStockBySymbol(order.getStockSymbol()).getCurrentPrice();
        MatchStrategy strategy = strategies.get(order.getOrderType());
        if(strategy.tryMatch(order,currentMarketPrice)){
            //process
        }else{
            //reject
        }
        //use some eventLogic to process the order
    }
}
