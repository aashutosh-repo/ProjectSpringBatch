package com.test.batch.schedular;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private Job processCustomerJob;

    // This method will run every 10 minutes
    @Scheduled(fixedRate = 30000)  // 600000 ms = 10 minutes delay
    public void runJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
            jobLauncher.run(processCustomerJob, jobParameters);
            System.out.println("Batch job triggered at: " + System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println("Error occurred while running the batch job: " + e.getMessage());
        }
    }
}

