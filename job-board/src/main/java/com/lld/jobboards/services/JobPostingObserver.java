package com.lld.jobboards.services;

import com.lld.jobboards.models.JobApplicationEvent;

public interface JobPostingObserver {
    void onEventUpdate(JobApplicationEvent jobApplicationEvent);
}
