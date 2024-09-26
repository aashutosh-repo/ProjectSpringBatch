package com.test.batch.schedular;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class WeatherBatchScheduler {

//    private final JobLauncher jobLauncher;
//    private final Job saveWeatherJobNew;
//    private final Job deleteWeatherJob;
//
//    @Autowired
//    public WeatherBatchScheduler(JobLauncher jobLauncher, @Qualifier("saveWeatherJobNew") Job saveWeatherJobNew, 
//                          @Qualifier("deleteWeatherJob") Job deleteWeatherJob) {
//        this.jobLauncher = jobLauncher;
//        this.saveWeatherJobNew = saveWeatherJobNew;
//        this.deleteWeatherJob = deleteWeatherJob;
//    }
//
//    public void runSaveWeatherJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, 
//                                            JobRestartException, JobInstanceAlreadyCompleteException {
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("time", System.currentTimeMillis())
//                .toJobParameters();
//        jobLauncher.run(saveWeatherJobNew, jobParameters);
//    }
//
//    public void runDeleteWeatherJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, 
//                                               JobRestartException, JobInstanceAlreadyCompleteException {
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("time", System.currentTimeMillis())
//                .toJobParameters();
//        jobLauncher.run(deleteWeatherJob, jobParameters);
//    }
}
