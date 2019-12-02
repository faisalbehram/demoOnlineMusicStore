package com.onlinemusicstore.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemusicstore.app.models.CustomerOrder;
import com.onlinemusicstore.app.repository.CustomerOrderRepository;

/**
 * Created by Le on 1/25/2016.
 */

@Repository
@Transactional
public class CustomerOrderDao{

       
        @Autowired 
        CustomerOrderRepository customerOrderRepo;
        
        
        public void addCustomerOrder(CustomerOrder customerOrder) {
        	System.out.println("customer Order are saved");
          customerOrderRepo.save(customerOrder);
        }
		public List<CustomerOrder> getAllOrder() {
			
			return customerOrderRepo.findAll();
		}
}
