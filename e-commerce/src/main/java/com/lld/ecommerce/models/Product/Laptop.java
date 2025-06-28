package com.lld.ecommerce.models.Product;

public class Laptop extends Product{
    public Laptop(int quantity, double cost, String seller) {
        super(quantity, cost, seller);
        this.productType = ProductType.LAPTOPS;
    }
}
