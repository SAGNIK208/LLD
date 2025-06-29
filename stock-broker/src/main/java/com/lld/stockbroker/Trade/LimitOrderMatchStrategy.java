package com.lld.stockbroker.Trade;

import com.lld.stockbroker.Order.Order;

import java.math.BigDecimal;

public class LimitOrderMatchStrategy implements MatchStrategy {
    @Override
    public boolean tryMatch(Order order, BigDecimal currentMarketPrice) {
        return order.canExecute(currentMarketPrice);
    }
}
