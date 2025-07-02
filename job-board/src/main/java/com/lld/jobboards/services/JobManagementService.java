package com.lld.jobboards.services;

import com.lld.jobboards.models.CompanyAccount;
import com.lld.jobboards.models.JobApplicationEvent;
import com.lld.jobboards.models.JobPosting;
import com.lld.jobboards.models.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobManagementService implements JobPostingSubject{
    private Map<String, List<JobPosting>> postedJobs;
    private Map<String,List<Profile>> jobApplications;
    private List<CompanyAccount> companyAccounts;
    public JobManagementService(){
        this.postedJobs = new HashMap<>();
        this.jobApplications = new HashMap<>();
        this.companyAccounts = new ArrayList<>();
    }
    public void createJobPosting(CompanyAccount company,JobPosting jobPosting){
        List<JobPosting> companyPosting = postedJobs.getOrDefault(company.getName(),new ArrayList<>());
        companyPosting.add(jobPosting);
        postedJobs.put(company.getName(),companyPosting);
    }
    public List<JobPosting> searchJobs(String companyName){
        return this.postedJobs.getOrDefault(companyName,new ArrayList<>());
    }
    public void applyForJob(String jobId,Profile profile){
        List<Profile> jobPostings = jobApplications.getOrDefault(jobId,new ArrayList<>());
        jobPostings.add(profile);
        jobApplications.put(jobId,jobPostings);
        notifyObservers(jobId,profile);
    }

    @Override
    public void registerObservers(CompanyAccount companyAccount) {
        this.companyAccounts.add(companyAccount);
    }

    @Override
    public void unregisterObservers(CompanyAccount companyAccount) {
        this.companyAccounts.remove(companyAccount);
    }

    @Override
    public void notifyObservers(String jobId,Profile profile) {
        for(CompanyAccount company : companyAccounts){
            List<JobPosting> postings = postedJobs.get(company.getName());
            for(JobPosting posting : postings){
                if(posting.getID().equals(jobId)){
                    company.onEventUpdate(new JobApplicationEvent(jobId,profile));
                }
            }
        }
    }
}
