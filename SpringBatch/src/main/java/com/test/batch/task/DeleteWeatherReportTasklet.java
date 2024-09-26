package com.test.batch.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.test.batch.repository.WeatherRepository;

@Component
public class DeleteWeatherReportTasklet implements Tasklet {
    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Delete all records from the WeatherReport table
    	System.out.println("Entered into DeleteWeatherReportTasklet");
    	weatherRepository.deleteAll();

        System.out.println("All records from the WeatherReport table have been deleted.");
        
        return RepeatStatus.FINISHED;
    }
}
