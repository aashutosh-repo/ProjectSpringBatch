package com.test.batch.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CustomJobListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Job started with ID: {}", jobExecution.getJobId());
        logger.info("Job parameters: {}", jobExecution.getJobParameters());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("Job completed with status: {}", jobExecution.getStatus());
        logger.info("Job finished with ID: {}", jobExecution.getJobId());
        
        if (jobExecution.getStatus().isUnsuccessful()) {
            logger.error("Job failed with the following exceptions:");
            jobExecution.getAllFailureExceptions().forEach(ex -> logger.error(ex.getMessage()));
        }
    }
}
