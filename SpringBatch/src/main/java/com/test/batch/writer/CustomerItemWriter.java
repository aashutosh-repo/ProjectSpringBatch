package com.test.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.test.batch.model.CustomerDetails;
import com.test.batch.processor.CustomerItemProcessor;
import com.test.batch.repository.CustomerDetailsRepository;

@Component
public class CustomerItemWriter implements ItemWriter<CustomerDetails> {
    private static final Logger logger = LoggerFactory.getLogger(CustomerItemWriter.class);

    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerItemWriter(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }
    
	@Override
	public void write(Chunk<? extends CustomerDetails> chunk) throws Exception {
		logger.info("Data Writing Started");
		// TODO Auto-generated method stub
		customerDetailsRepository.saveAll(chunk);
		for (CustomerDetails customerDetails : chunk) {
            // Check if the record already exists before saving
            if (!customerDetailsRepository.existsByFirstNameAndLastName(
                customerDetails.getFirstName(), 
                customerDetails.getLastName())) {
                customerDetailsRepository.save(customerDetails);
            }
        }
		
	}
}