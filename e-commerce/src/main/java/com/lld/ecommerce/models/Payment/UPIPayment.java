package com.lld.ecommerce.models.Payment;

public class UPIPayment implements PaymentMethod{
    @Override
    public boolean makePayment(double amount) {
        return true;
    }
}
