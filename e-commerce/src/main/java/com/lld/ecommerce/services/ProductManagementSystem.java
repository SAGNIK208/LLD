package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Product.Product;
import com.lld.ecommerce.models.Product.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagementSystem {
    List<Product> products;
    public ProductManagementSystem(List<Product> products){
        this.products = products;
    }
    public List<Product> search(ProductType productType,Integer rating){
        return products.stream()
                .filter(p -> productType == null || p.getProductType().equals(productType))
                .filter(p -> rating == null || p.getRating() >= rating)
                .collect(Collectors.toList());
    }
}
