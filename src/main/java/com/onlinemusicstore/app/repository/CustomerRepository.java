package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlinemusicstore.app.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUsername(String username);

	@Query("FROM Customer Where customerEmail =?1")
	Customer findByCustomerEmail(String email);

}
