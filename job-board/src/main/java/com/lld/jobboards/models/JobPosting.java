package com.lld.jobboards.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class JobPosting {
    private final String ID;
    private final String companyName;
    private final String role;
    private final List<String> requirements;
    private final String location;
    private final LocalDate postingDate;
    private final int yearsOfExperiencedRequired;
    public JobPosting(String role,String companyName, List<String> requirements, String location, int yearsOfExperiencedRequired){
        this.ID = UUID.randomUUID().toString();
        this.companyName = companyName;
        this.requirements = requirements;
        this.role = role;
        this.location = location;
        this.yearsOfExperiencedRequired = yearsOfExperiencedRequired;
        this.postingDate = LocalDate.now();
    }

    public String getID() {
        return ID;
    }

    public String getRole() {
        return role;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public int getYearsOfExperiencedRequired() {
        return yearsOfExperiencedRequired;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "ID='" + ID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", requirements=" + requirements +
                ", location='" + location + '\'' +
                ", postingDate=" + postingDate +
                ", yearsOfExperiencedRequired=" + yearsOfExperiencedRequired +
                '}';
    }
}
