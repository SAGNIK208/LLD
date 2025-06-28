package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Order.Order;
import com.lld.ecommerce.models.Payment.Payment;
import com.lld.ecommerce.models.Payment.PaymentMethod;
import com.lld.ecommerce.models.Payment.PaymentStatus;

public class PaymentManagementSystem {
    public static Payment pay(Order order,PaymentMethod paymentMethod){
       Payment payment = new Payment(paymentMethod);
       boolean isSuccess = paymentMethod.makePayment(order.getTotal());
       if(isSuccess){
           payment.updateStatus(PaymentStatus.ACCEPTED);
       }else{
           payment.updateStatus(PaymentStatus.DECLINED);
       }
       return payment;
    }
}
