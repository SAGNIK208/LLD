package com.lld.jobboards.models;

import java.util.UUID;

public abstract class Account {
    private final String ID;
    private String username;
    private String password;
    protected AccountType accountType;
    private String name;
    public Account(String username,String password,String name){
        this.ID = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
