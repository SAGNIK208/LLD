package com.lld.stockbroker.Trade;

import com.lld.stockbroker.Order.Order;

import java.math.BigDecimal;

public interface MatchStrategy {
    boolean tryMatch(Order order, BigDecimal currentMarketPrice);
}
