package com.lld.ecommerce.models.Product;

import java.util.UUID;

public abstract class Product {
    private final String ID;
    private int rating;
    private int quantity;
    private double cost;
    private String seller;
    protected ProductType productType;

    public Product(int quantity,double cost,String seller){
        ID = UUID.randomUUID().toString();
        this.seller = seller;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public int getRating() {
        return rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public String getSeller() {
        return seller;
    }

    public ProductType getProductType() {
        return productType;
    }
}
