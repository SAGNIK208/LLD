package com.lld.parkinglot.Payment;

public class UPIPayment implements PaymentMethod{
    @Override
    public boolean pay(double amount) {
        return true;
    }
}
