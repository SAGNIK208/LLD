package com.lld.ecommerce.models.Payment;

import com.lld.ecommerce.models.Cart.Cart;

public interface PaymentStrategy {
    double calculateAmount(Cart cart);
}
