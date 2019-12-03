package com.onlinemusicstore.app.service;


import java.util.List;
import java.util.Optional;

import com.onlinemusicstore.app.models.Customer;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerService {

    void addCustomer (Customer customer);

    Optional<Customer> getCustomerById (int customerId);
    
    Customer getCustomer (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
    

	Customer getCustomerByEmail(String email);
}
