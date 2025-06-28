package com.lld.ecommerce.models.Order;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Cart.Cart;
import com.lld.ecommerce.models.Product.Product;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String ID;
    private Account account;
    private List<Product> products;
    private double total;
    private String address;

    public Order(Cart cart, double total,String address){
        ID = UUID.randomUUID().toString();
        this.account = cart.getAccount();
        this.products = cart.getProducts();
        this.total = total;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public Account getAccount() {
        return account;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public String getAddress(){
        return address;
    }

}
