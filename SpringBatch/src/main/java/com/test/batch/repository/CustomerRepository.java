package com.test.batch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.batch.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("SELECT c FROM Customer c WHERE c.custId > :custId")
    List<Customer> findByCustIdGreaterThan(@Param("custId") int custId);
}

