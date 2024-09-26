package com.test.batch.contoller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/weather")
public class WeatherController {

//    @Autowired
//    private TaskExecutorJobLauncher jobLauncher;
//
//    @Autowired
//    private Job deleteWeatherJob;
//    
//    @Autowired
//    private Job saveWeatherJob;
//
//    @PostMapping("/delete")
//    public ResponseEntity<String> deleteWeatherRecords() {
//        try {
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addLong("time", System.currentTimeMillis())
//                    .toJobParameters();
//
//            // Trigger the job asynchronously
//            jobLauncher.run(deleteWeatherJob, jobParameters);
//
//            return ResponseEntity.ok("Weather records deletion triggered successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to trigger weather records deletion: " + e.getMessage());
//        }
//    }
//    
//    @PostMapping("/startWeatherJob")
//    public ResponseEntity<String> startWeatherJob() {
//        try {
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addLong("time", System.currentTimeMillis())
//                    .toJobParameters();
//            jobLauncher.run(saveWeatherJob, jobParameters);
//            return ResponseEntity.ok("Weather batch job has been started.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Weather batch job failed to start.");
//        }
//    }
}


