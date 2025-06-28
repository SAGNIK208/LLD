package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Cart.Cart;
import com.lld.ecommerce.models.Order.Order;
import com.lld.ecommerce.models.Payment.PaymentStrategy;

public class OrderManagementSystem {
    public static Order placeOrder(Cart cart, PaymentStrategy paymentStrategy,String address){
        return new Order(cart, paymentStrategy.calculateAmount(cart),address);
    }
}
