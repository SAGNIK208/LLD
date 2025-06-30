package com.lld.hotelbooking.models;

public class BasicUser extends User{
    public BasicUser(String name) {
        super(name);
        this.userType = UserType.BASIC_USER;
    }
}
