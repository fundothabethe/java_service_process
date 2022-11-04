package com.example.java_service;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class Job_service extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        return false;
    }
}
