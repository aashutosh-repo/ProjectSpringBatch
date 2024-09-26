package com.test.batch.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.test.batch.model.Weather;
import com.test.batch.repository.WeatherRepository;

//@Configuration
//@EnableBatchProcessing
public class BatchConfig {
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Autowired
//    private WeatherRepository weatherRepository;
//
//    // Tasklet to delete weather records
//    @Bean
//    public Tasklet deleteWeatherTasklet() {
//        return (contribution, chunkContext) -> {
//            weatherRepository.deleteAll();  // Delete all records
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    // Define the step
//    @Bean
//    public Step deleteWeatherStep() {
//        return new StepBuilder("deleteWeatherStep", jobRepository)
//                .tasklet(deleteWeatherTasklet(), transactionManager)
//                .build();
//    }
//
//    // Define the job
//    @Bean
//    public Job deleteWeatherJob() {
//        return new JobBuilder("deleteWeatherJob", jobRepository)
//                .start(deleteWeatherStep())
//                .build();
//    }
//
//
//    // Configure TaskExecutorJobLauncher
//    @Bean
//    public TaskExecutorJobLauncher jobLauncher(TaskExecutor taskExecutor) {
//        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
//        jobLauncher.setJobRepository(jobRepository);
//        jobLauncher.setTaskExecutor(taskExecutor);  // Using TaskExecutor for asynchronous job launching
//        return jobLauncher;
//    }
//
//    // Configure a TaskExecutor
//    @Bean
//    public TaskExecutor taskExecutor() {
//        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
//        taskExecutor.setConcurrencyLimit(10);  // Set concurrency limit as needed
//        return taskExecutor;
//    }
//    
//    
//
//
//    
//    @Bean
//    public Job saveWeatherJob() {
//        return new JobBuilder("saveWeatherJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(saveWeatherStep())
//                .build();
//    }
//
//    @Bean
//    public Step saveWeatherStep() {
//        return new StepBuilder("saveWeatherStep", jobRepository)
//                .<Weather, Weather>chunk(10, transactionManager)
//                .reader(weatherReader())
//                .processor(weatherProcessor())
//                .writer(weatherWriter())
//                .build();
//    }
//
//    @Bean
//    public ItemReader<Weather> weatherReader() {
//        return new ListItemReader<>(Arrays.asList(
//            // Sample Weather Data
//            new Weather(1L,"New York", "Sunny", LocalDate.now()),
//            new Weather(2L,"Los Angeles", "Rainy", LocalDate.now())
//        ));
//    }
//
//    @Bean
//    public ItemProcessor<Weather, Weather> weatherProcessor() {
//        return weather -> {
//            // Any processing logic can be added here
//            System.out.println("Processing weather: " + weather.getLocation());
//            return weather;
//        };
//    }
//
//    @Bean
//    public ItemWriter<Weather> weatherWriter() {
//        return weatherList -> weatherRepository.saveAll(weatherList);
//    }
//    
    
}