package com.lld.hotelbooking.models;

import java.util.UUID;

public abstract class User {
    private final String ID;
    private String name;
    protected UserType userType;
    public User(String name){
        this.ID = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
