package com.onlinemusicstore.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.BillingAddress;
import com.onlinemusicstore.app.repository.BillingRepository;

@Repository
public class BillingDao {
	
	@Autowired
	private BillingRepository billingRepository;
	
	public void saveBilling(BillingAddress address,BillingAddress billingAddress) {
		
		billingAddress.setCustomer(address.getCustomer());
		billingRepository.save(billingAddress);
		
	}

}
