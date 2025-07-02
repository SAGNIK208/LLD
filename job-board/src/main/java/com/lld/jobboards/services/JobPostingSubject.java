package com.lld.jobboards.services;

import com.lld.jobboards.models.CompanyAccount;
import com.lld.jobboards.models.Profile;

public interface JobPostingSubject {
    void registerObservers(CompanyAccount companyAccount);
    void unregisterObservers(CompanyAccount companyAccount);
    void notifyObservers(String jobId, Profile profile);
}
