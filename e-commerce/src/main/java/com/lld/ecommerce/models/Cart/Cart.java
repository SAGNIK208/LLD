package com.lld.ecommerce.models.Cart;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Account account;
    private List<Product> products;
    public Cart(Account account){
        this.account = account;
        this.products = new ArrayList<>();
    }

    public Account getAccount() {
        return account;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void updateProduct(Product product){
        this.products.add(product);
    }
}
