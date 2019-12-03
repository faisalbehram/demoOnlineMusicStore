package com.onlinemusicstore.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.ShippingAddress;
import com.onlinemusicstore.app.repository.ShippingRepository;

@Repository
public class ShippingDao {
	
	@Autowired
	private ShippingRepository shippingRepository;
	
	public void saveShipping(ShippingAddress address,ShippingAddress shippingAddress) {
		
		System.out.println("the shiping are saved + " );
		
		shippingAddress.setCustomer(shippingAddress.getCustomer());
		
		shippingAddress.setCustomer(address.getCustomer());
		
		System.out.println("the shiping are saved" + shippingAddress.getCustomer());
		

		System.out.println("the shiping are saved" + shippingAddress.getCustomer().getCustomerId());
		
		shippingRepository.save(shippingAddress);
		
	}

}
