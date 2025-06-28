package com.lld.ecommerce.models.Payment;

import java.util.UUID;

public class Payment {
    private final String ID; // transactionId
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    public Payment(PaymentMethod paymentMethod){
        ID = UUID.randomUUID().toString();
        paymentStatus = PaymentStatus.PROCESSING;
        this.paymentMethod = paymentMethod;
    }
    public void updateStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public String getID() {
        return ID;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
