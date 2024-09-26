package com.test.batch.task;

import java.time.LocalDate;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.batch.model.Weather;
import com.test.batch.repository.WeatherRepository;

//@Component
public class SaveWeatherReportTasklet implements Tasklet {

    @Autowired
    private WeatherRepository weatherReportRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Create a new WeatherReport entity
        Weather weatherReport = new Weather();
        weatherReport.setId(System.currentTimeMillis());  // Set unique ID (using current time)
        weatherReport.setLocation("New York");  // Example city
        weatherReport.setDate(LocalDate.now());  // Example date (you could use the current date)

        // Save the WeatherReport to the database
        weatherReportRepository.save(weatherReport);
        System.out.println("WeatherReport saved successfully.");

        return RepeatStatus.FINISHED;
    }
}
