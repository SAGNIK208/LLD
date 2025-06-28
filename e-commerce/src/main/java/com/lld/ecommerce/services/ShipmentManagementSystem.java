package com.lld.ecommerce.services;

import com.lld.ecommerce.models.Order.Order;
import com.lld.ecommerce.models.Product.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipmentManagementSystem {
    public Map<String,LocalDateTime> expectedTimeOfDelivery(Order order){
        Map<String,LocalDateTime> expectedTOD = new HashMap<>();
        List<Product> products = order.getProducts();
        String address = order.getAddress();
        //some address and product logic and get time
        for(Product product : products){
            expectedTOD.put(product.getID(),LocalDateTime.now().plusDays(5));
        }
        return expectedTOD;
    }
}
