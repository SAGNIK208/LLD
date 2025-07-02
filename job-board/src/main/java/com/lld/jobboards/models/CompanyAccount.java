package com.lld.jobboards.models;

import com.lld.jobboards.services.JobPostingObserver;

public class CompanyAccount extends Account implements JobPostingObserver {
    public CompanyAccount(String username, String password,String name) {
        super(username, password,name);
        this.accountType = AccountType.COMPANY;
    }

    @Override
    public void onEventUpdate(JobApplicationEvent jobApplicationEvent) {
        // perform some action
        System.out.println("Received Application " + getName());
    }
}
