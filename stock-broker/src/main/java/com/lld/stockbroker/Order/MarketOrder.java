package com.lld.stockbroker.Order;

import java.math.BigDecimal;

public class MarketOrder extends Order{

    public MarketOrder(String accountId, String stockSymbol, OrderSide orderSide,int quantity) {
        super(accountId, stockSymbol, orderSide,quantity);
        this.orderType = OrderType.MARKET_ORDER;
    }
    @Override
    public boolean canExecute(BigDecimal currentPrice) {
        return true;
    }
}
