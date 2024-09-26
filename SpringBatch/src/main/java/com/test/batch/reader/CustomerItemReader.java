package com.test.batch.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.batch.model.Customer;
import com.test.batch.model.CustomerReadingRecords;
import com.test.batch.repository.CustomerDetailsRepository;
import com.test.batch.repository.CustomerRecordsRepository;
import com.test.batch.repository.CustomerRepository;


@Component
@StepScope
public class CustomerItemReader implements ItemReader<Customer>{
    private static final Logger logger = LoggerFactory.getLogger(CustomerItemReader.class);

	private final CustomerRepository customerRepository;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired
	CustomerRecordsRepository customerRecordsRepository;
	
    private int currentIndex = 0;
	int maxCustId=0;
    private List<Customer> customers;
    
    @Autowired
    public CustomerItemReader(CustomerRepository customerRepository,CustomerRecordsRepository customerRecordsRepository) {
        this.customerRepository = customerRepository;
        maxCustId  = customerRecordsRepository.findMaxLastUpdatedCustId();
    }


    
    @Override
    public Customer read() {
    	
    	logger.info("Reading Data ");
    	CustomerReadingRecords rec = new CustomerReadingRecords();
    	//maxCustId  = customerRecordsRepository.findMaxLastUpdatedCustId();
    	List<Customer> allCust = customerRepository.findByCustIdGreaterThan(maxCustId);
        // Fetch the customers from the database if the list is null or fully read
        if (customers == null || customerRepository.findByCustIdGreaterThan(maxCustId).size() >= customers.size()) {
            customers = customerRepository.findByCustIdGreaterThan(maxCustId);
            currentIndex = 0;
        }

//        // Return the next customer if available
//        if (currentIndex < customers.size()) {
//            return customers.get(currentIndex++);
//        }
        
        for(Customer c : allCust) {
        	if(c.getCustId() > maxCustId) {
        		maxCustId = c.getCustId().intValue();
                rec.setLastUpdatedCustId(maxCustId);
        		rec.setSeqId(maxCustId);
        		customerRecordsRepository.save(rec);
        		maxCustId = c.getCustId().intValue();
        		return customers.get(currentIndex++);
        	}
        }

		
        // Return null to indicate the end of data
        return null;
    }
}
