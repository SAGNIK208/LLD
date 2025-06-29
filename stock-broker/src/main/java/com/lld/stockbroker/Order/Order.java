package com.lld.stockbroker.Order;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Order {
    private final String ID;
    private final String accountId;
    private final String stockSymbol;
    private final long createdTimestamp;
    protected final OrderSide orderSide;
    protected final int quantity;
    protected OrderStatus orderStatus;
    protected OrderType orderType;
    protected Order(String accountId, String stockSymbol, OrderSide orderSide,int quantity) {
        ID = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.stockSymbol = stockSymbol;
        this.orderSide = orderSide;
        this.quantity = quantity;
        this.createdTimestamp = System.currentTimeMillis();
    }
    public boolean isValid(){
        return this.quantity > 0;
    }
    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    public String getID() {
        return ID;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public abstract boolean canExecute(BigDecimal currentPrice);
}
