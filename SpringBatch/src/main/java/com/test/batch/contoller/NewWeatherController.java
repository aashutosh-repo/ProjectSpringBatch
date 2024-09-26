package com.test.batch.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.batch.schedular.WeatherBatchScheduler;

//@RestController
//@RequestMapping("/weather/batch")
public class NewWeatherController {

//    private final WeatherBatchScheduler batchScheduler;
//
//    @Autowired
//    public NewWeatherController(WeatherBatchScheduler batchScheduler) {
//        this.batchScheduler = batchScheduler;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<String> triggerSaveWeatherJob() {
//        try {
//            batchScheduler.runSaveWeatherJob();
//            return ResponseEntity.ok("Save Weather Batch Job triggered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to trigger save weather job");
//        }
//    }
//
//    @PostMapping("/delete")
//    public ResponseEntity<String> triggerDeleteWeatherJob() {
//        try {
//            batchScheduler.runDeleteWeatherJob();
//            return ResponseEntity.ok("Delete Weather Batch Job triggered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to trigger delete weather job");
//        }
//    }
}
