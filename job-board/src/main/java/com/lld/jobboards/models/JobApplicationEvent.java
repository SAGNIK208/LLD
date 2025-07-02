package com.lld.jobboards.models;

public class JobApplicationEvent {
    private final String jobId;
    private final Profile profile;
    public JobApplicationEvent(String jobId,Profile profile){
        this.jobId = jobId;
        this.profile = profile;
    }
    public String getJobId() {
        return jobId;
    }

    public Profile getProfile() {
        return profile;
    }
}
