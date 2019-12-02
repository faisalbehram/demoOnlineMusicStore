//package com.onlinemusicstore.app.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.onlinemusicstore.app.models.Price;
//import com.onlinemusicstore.app.repository.PriceRepository;
//
//@Repository
//public class PriceDao {
//
//	@Autowired
//	private PriceRepository priceRepository;
//	
//	public void savePrice(Price price) {
//		priceRepository.save(price);
//	}
//
//	public List<Price> findByProductId(String productId) {
//		List<Price> price = priceRepository.findByProductProductId(productId);
//		System.out.println("the product id is from priceDao is " + price);
//		return price;
//	}
//}
