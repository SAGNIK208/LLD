package com.lld.ecommerce.models.Account;

import java.util.List;
import java.util.UUID;

public abstract class Account {
    private final String id;
    private String name;
    private String username;
    private String password;
    private List<String> addresses;
    protected AccountType accountType;

    public Account(String name,String username,String password,List<String> addresses){
        id = UUID.randomUUID().toString();
        this.name = name;
        this.username = username;
        this.password = password;
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
