package com.onlinemusicstore.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void saveCustomer(Customer customer) {
		System.out.println("the CUstomer are saved");
		customerRepository.save(customer);
		
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	 public Optional<Customer> getCustomerById(int customerId) {
		 return customerRepository.findById(customerId);
	 }

	public Customer getByUserName(String username) {
		System.out.println("in findbyUsername in customer Dao " );
		return customerRepository.findByUsername(username);
	}

	public Customer getByEmail(String email) {
		System.out.println("in findByEmail in customer " );
		Customer  customer = customerRepository.findByCustomerEmail(email);
		System.out.println("in findByEmail in customer " + customer.getCustomerEmail() );
		return customer;
	}

	
	

}
