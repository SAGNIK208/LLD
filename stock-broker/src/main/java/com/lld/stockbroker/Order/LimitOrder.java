package com.lld.stockbroker.Order;

import java.math.BigDecimal;

public class LimitOrder extends Order{
    private BigDecimal limitPrice;
    public LimitOrder(String accountId, String stockSymbol, OrderSide orderSide,int quantity, BigDecimal limitPrice) {
        super(accountId, stockSymbol, orderSide,quantity);
        this.orderType = OrderType.LIMIT_ORDER;
        this.limitPrice = limitPrice;
    }
    @Override
    public boolean isValid(){
        return this.quantity > 0 && this.limitPrice.compareTo(BigDecimal.ZERO) > 0;
    }
    @Override
    public boolean canExecute(BigDecimal currentPrice) {
        switch (this.orderSide){
            case BUY:
                return currentPrice.compareTo(limitPrice) <= 0;
            case SELL:
                return currentPrice.compareTo(limitPrice) >= 0;
        }
        return false;
    }
}
