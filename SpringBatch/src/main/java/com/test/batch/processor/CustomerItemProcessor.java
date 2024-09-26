package com.test.batch.processor;

import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.test.batch.model.Customer;
import com.test.batch.model.CustomerDetails;

@Component
public class CustomerItemProcessor implements ItemProcessor<Customer, CustomerDetails> {
    private static final Logger logger = LoggerFactory.getLogger(CustomerItemProcessor.class);


    @Override
    public CustomerDetails process(Customer customer) throws Exception {
    	logger.info("data proocessing Started ");
    	
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(customer.getFirstName());
        customerDetails.setLastName(customer.getLastName());

        // Calculate age
        LocalDate dob = customer.getDateOfBirth();
        int age = Period.between(dob, LocalDate.now()).getYears();

        // Determine custType
        if (age < 18) {
            customerDetails.setCustType("minor");
        } else if (age >= 60) {
            customerDetails.setCustType("Senior Citizen");
        } else {
            customerDetails.setCustType("adult");
        }

        return customerDetails;
    }
}
