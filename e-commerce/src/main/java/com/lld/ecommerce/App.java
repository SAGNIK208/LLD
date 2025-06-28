package com.lld.ecommerce;

import com.lld.ecommerce.models.Account.Account;
import com.lld.ecommerce.models.Account.AccountType;
import com.lld.ecommerce.models.Cart.Cart;
import com.lld.ecommerce.models.Order.Order;
import com.lld.ecommerce.models.Payment.*;
import com.lld.ecommerce.models.Product.Laptop;
import com.lld.ecommerce.models.Product.Product;
import com.lld.ecommerce.models.Product.ProductType;
import com.lld.ecommerce.services.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Product>products = new ArrayList<>();
        Product product1 = new Laptop(1,1_00_000,"appleStores");
        Product product2 = new Laptop(1,70_000,"dellStores");
        products.add(product1);
        products.add(product2);
        ProductManagementSystem pms = new ProductManagementSystem(products);
        List<Product> searchResults = pms.search(ProductType.LAPTOPS,null);
        System.out.println(searchResults);
        AccountManagementSystem ams = new AccountManagementSystem();
        List<String> address = new ArrayList<>();
        address.add("India");
        Account account = ams.createAccount(AccountType.PRIME,"test","1234","sg",address);
        CartManagementSystem cms = new CartManagementSystem();
        Cart cart = cms.createCart(account);
        cms.addProduct(account,product1);
        PaymentStrategy paymentStrategy = new FestiveStrategy();
        Order order = OrderManagementSystem.placeOrder(cart,paymentStrategy,address.get(0));
        PaymentMethod paymentMethod = new UPIPayment();
        Payment payment = PaymentManagementSystem.pay(order,paymentMethod);
        System.out.println(payment.getPaymentStatus());
        ShipmentManagementSystem shipmentManagementSystem = new ShipmentManagementSystem();
        Map<String, LocalDateTime> etas = shipmentManagementSystem.expectedTimeOfDelivery(order);
        for(Map.Entry entry : etas.entrySet()){
            System.out.println(entry.getKey() + "    " + entry.getValue());
        }
    }
}
