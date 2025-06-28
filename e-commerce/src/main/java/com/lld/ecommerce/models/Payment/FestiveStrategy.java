package com.lld.ecommerce.models.Payment;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Cart.Cart;
import com.lld.ecommerce.models.Product.Product;

import java.util.List;

public class FestiveStrategy implements  PaymentStrategy {

    @Override
    public double calculateAmount(Cart cart) {
        Account account = cart.getAccount();
        List<Product> products = cart.getProducts();
        double total = 0;
        for(Product product : products){
            total+=product.getCost();
        }
        return total - 10;
    }
}
