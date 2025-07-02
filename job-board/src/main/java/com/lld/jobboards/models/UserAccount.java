package com.lld.jobboards.models;

public class UserAccount extends Account{
    private Profile profile;
    private int yoe;
    public UserAccount(String username, String password,String name,int yoe) {
        super(username, password,name);
        this.accountType = AccountType.USER;
        this.yoe = yoe;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
