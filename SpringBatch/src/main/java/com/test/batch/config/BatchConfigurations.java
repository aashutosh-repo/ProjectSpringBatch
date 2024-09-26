package com.test.batch.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.test.batch.model.Weather;
import com.test.batch.repository.WeatherRepository;

//@Configuration
//@EnableBatchProcessing
public class BatchConfigurations {

//    private final JobRepository jobRepository;
//    private final PlatformTransactionManager transactionManager;
//
//    @Autowired
//    public BatchConfigurations(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        this.jobRepository = jobRepository;
//        this.transactionManager = transactionManager;
//    }
//
//    @Bean
//    public Job saveWeatherJobNew(Step saveWeatherStepNew) {
//        return new JobBuilder("saveWeatherJobNew", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(saveWeatherStepNew)
//                .build();
//    }
//
//    @Bean
//    public Step saveWeatherStepNew(WeatherRepository weatherRepository) {
//        return new StepBuilder("saveWeatherStepNew", jobRepository)
//                .<Weather, Weather>chunk(10, transactionManager)
//                .reader(weatherItemReader())
//                .processor(weatherItemProcessor())
//                .writer(weatherItemWriter(weatherRepository))
//                .build();
//    }
//
//    @Bean
//    public Job deleteWeatherJobNew(Step deleteWeatherStep) {
//        return new JobBuilder("deleteWeatherJobNew", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(deleteWeatherStep)
//                .build();
//    }
//
//    @Bean
//    public Step deleteWeatherStepNew(WeatherRepository weatherRepository) {
//        return new StepBuilder("deleteWeatherStepNew", jobRepository)
//                .<Weather, Weather>chunk(10, transactionManager)
//                .reader(deleteWeatherItemReader())
//                .processor(deleteWeatherItemProcessor())
//                .writer(deleteWeatherItemWriter(weatherRepository))
//                .build();
//    }
//
//    // Define readers, processors, and writers for both save and delete jobs
//
//    @Bean
//    public ItemReader<Weather> weatherItemReader() {
//        // Implement logic to read Weather data for saving
//        return new ListItemReader<>(List.of(new Weather(1l,"New Delhi","HOT",LocalDate.now()),
//        		new Weather(2l,"Bengalore","NORMAL",LocalDate.now()),
//        		new Weather(3l,"JAMMU","COOL",LocalDate.now())));
//    }
//
//    @Bean
//    public ItemProcessor<Weather, Weather> weatherItemProcessor() {
//        // Implement logic to process Weather data before saving
//        return item -> item;  // No-op, just passing the item through for now
//    }
//
//    @Bean
//    public ItemWriter<Weather> weatherItemWriter(WeatherRepository weatherRepository) {
//        return items -> weatherRepository.saveAll(items);
//    }
//
//    @Bean
//    public ItemReader<Weather> deleteWeatherItemReader() {
//        // Implement logic to read Weather data for deletion
//        return new ListItemReader<>(List.of(/* Criteria-based Weather data to delete */));
//    }
//
//    @Bean
//    public ItemProcessor<Weather, Weather> deleteWeatherItemProcessor() {
//        // Process Weather data before deletion if necessary
//        return item -> item;  // No-op, just passing the item through
//    }
//
//    @Bean
//    public ItemWriter<Weather> deleteWeatherItemWriter(WeatherRepository weatherRepository) {
//        return items -> weatherRepository.deleteAll(items);
//    }
}


