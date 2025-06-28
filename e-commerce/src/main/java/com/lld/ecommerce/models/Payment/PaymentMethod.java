package com.lld.ecommerce.models.Payment;

public interface PaymentMethod {
    boolean makePayment(double amount);
}
