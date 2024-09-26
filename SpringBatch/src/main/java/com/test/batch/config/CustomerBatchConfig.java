package com.test.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.test.batch.listner.CustomJobListener;
import com.test.batch.model.Customer;
import com.test.batch.model.CustomerDetails;
import com.test.batch.processor.CustomerItemProcessor;
import com.test.batch.reader.CustomerItemReader;
import com.test.batch.repository.CustomerDetailsRepository;
import com.test.batch.repository.CustomerRepository;
import com.test.batch.writer.CustomerItemWriter;

@Configuration
@EnableBatchProcessing
public class CustomerBatchConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    
    @Autowired
    private CustomerItemReader customerItemReader; // Use custom reader

    @Autowired
    private CustomerItemWriter customerItemWriter; // Use custom writer
    @Autowired
    private CustomerItemProcessor customerItemProcessor;

    @Bean
    public Job processCustomerJob(JobRepository jobRepository, Step customerStep,CustomJobListener listener) {
        return new JobBuilder("processCustomerJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(customerStep)
                .build();
    }

    @Bean
    public Step customerStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("customerStep", jobRepository)
                .<Customer, CustomerDetails>chunk(10, transactionManager)
                .reader(customerItemReader)
                .processor(customerItemProcessor)
                .writer(customerItemWriter)
                .build();
    }

//    @Bean
//    public ItemReader<Customer> customerReader() {
//    	 Map<String, Sort.Direction> sorts = new HashMap<>();
//    	    sorts.put("custId", Sort.Direction.ASC);
//        return new RepositoryItemReaderBuilder<Customer>()
//        		.name("customerReader")
//                .repository(customerRepository)
//                .methodName("findAll")
//                .pageSize(10)
//                .sorts(sorts)
//                .build();
//    }

    

//    @Bean
//    public ItemProcessor<Customer, CustomerDetails> customerProcessor() {
//        return new CustomerItemProcessor();
//    }
    

//    @Bean
//    public ItemWriter<CustomerDetails> customerWriter() {
//        return new RepositoryItemWriterBuilder<CustomerDetails>()
//                .repository(customerDetailsRepository)
//                .methodName("save")
//                .build();
//    }
}
