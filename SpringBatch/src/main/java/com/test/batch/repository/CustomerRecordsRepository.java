package com.test.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.batch.model.CustomerReadingRecords;

public interface CustomerRecordsRepository extends JpaRepository<CustomerReadingRecords, Integer>{
	@Query("SELECT MAX(c.lastUpdatedCustId) FROM CustomerReadingRecords c")
    int findMaxLastUpdatedCustId();
	

}
