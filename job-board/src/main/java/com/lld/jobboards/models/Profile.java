package com.lld.jobboards.models;

import java.util.List;

public class Profile {
    private String userId;
    private List<String> skills;
    private List<Experience> experiences;
    public Profile(String id,List<String> skills,List<Experience> experiences){
        this.userId = id;
        this.skills = skills;
        this.experiences = experiences;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
