package com.lld.jobboards;

import com.lld.jobboards.models.*;
import com.lld.jobboards.services.JobManagementService;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CompanyAccount account1 = new CompanyAccount("apple","apple","APPLE");
        CompanyAccount account2 = new CompanyAccount("amazon","amazon","AMAZON");
        UserAccount user1 = new UserAccount("username","pass","sg",4);
        Experience experience = new Experience("Google","SDE2",3,new ArrayList<>());
        List<Experience> experiences = new ArrayList<>();
        experiences.add(experience);
        Profile profile = new Profile(user1.getID(),new ArrayList<>(),experiences);
        user1.setProfile(profile);
        JobPosting posting1 = new JobPosting("SDE2",account1.getName(),new ArrayList<>(),"Bengaluru",3);
        JobPosting posting2 = new JobPosting("SDE2",account2.getName(),new ArrayList<>(),"Bengaluru",3);
        JobManagementService jobManagementService = new JobManagementService();
        jobManagementService.registerObservers(account1);
        jobManagementService.registerObservers(account2);
        jobManagementService.createJobPosting(account1,posting1);
        jobManagementService.createJobPosting(account2,posting2);
        List<JobPosting> applePostings = jobManagementService.searchJobs("APPLE");
        List<JobPosting> amazonPostings = jobManagementService.searchJobs("AMAZON");
        System.out.println(applePostings);
        System.out.println(amazonPostings);
        jobManagementService.applyForJob(posting1.getID(),user1.getProfile());
    }
}
