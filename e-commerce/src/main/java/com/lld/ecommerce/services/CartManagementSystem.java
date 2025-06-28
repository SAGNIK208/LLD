package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Cart.Cart;
import com.lld.ecommerce.models.Product.Product;

import java.util.HashMap;
import java.util.Map;

public class CartManagementSystem {
    private Map<String,Cart> carts = new HashMap<>();
    public Cart createCart(Account account){
        if(carts.get(account.getId()) != null){
            return carts.get(account.getId());
        }
        Cart cart = new Cart(account);
        carts.put(account.getId(),cart);
        return cart;
    }
    public void addProduct(Account account,Product product){
        Cart cart = this.carts.get(account.getId());
        cart.getProducts().add(product);
    }
}
