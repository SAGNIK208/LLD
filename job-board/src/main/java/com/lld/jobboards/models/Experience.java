package com.lld.jobboards.models;

import java.util.List;

public class Experience {
    private final String company;
    private final String role;
    private final int years;
    private final List<String> responsibilities;

    public Experience(String company,String role,int years,List<String> responsibilities){
        this.company = company;
        this.role = role;
        this.years = years;
        this.responsibilities = responsibilities;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public int getYears() {
        return years;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }
}
