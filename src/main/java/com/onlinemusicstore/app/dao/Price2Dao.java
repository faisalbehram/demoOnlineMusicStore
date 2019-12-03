package com.onlinemusicstore.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.Price2;
import com.onlinemusicstore.app.repository.Price2Repository;

// this is price2 Dao
@Repository
public class Price2Dao {

	@Autowired
	private Price2Repository price2Repository;
	
	// to save the price
	public void savePrice(Price2 price2) {
		price2Repository.save(price2);
	}

	//return list of price2 by product id no constrant are there
	public List<Price2> findByProductId(String productId) {
		List<Price2> price = price2Repository.findByProductProductId(productId);
		System.out.println("the product id is from priceDao is " + price);
		return price;
	}
	
	// now find the product by id and get the basic discount to show to the user
	public Optional<Price2> findProductForViewProduct(String productId) {
		Optional<Price2> price = price2Repository.findByProductForViewProductDiscount(productId);
		System.out.println("the product id is from priceDao is " + price);
		return price;
	}
	
	public Optional<Price2> findByPro(String productId) {
		
		Optional<Price2> price = price2Repository.findProduct(productId);
		System.out.println("the product id is from priceDao is in findByPro  " + price);
		return price;
	}
	
	
	
	
//	public List<Price2> allPrice(){
//		return price2Repository.findAllPrices();
//	}
	
	// all basic prices
	public List<Price2> findAllBasicPrice(){
		return price2Repository.findAllBasicPrice();
	}
	
	// all disocunt prices where product id is not null
	public List<Price2> findAllDiscountPrice()
	{
		return price2Repository.findAllDiscountPrice();
	}
	
	// it return all list of product where product id is not null 
	public List<Price2> findProductPriceForUpdate(String productId)
	{
		return price2Repository.findProductPriceForUpdate(productId);
	}
	
	// all discount where product id is null
	
	
	

	public Optional<Price2> findById(int priceId) {
		Optional<Price2> price2 = price2Repository.findById(priceId);
		return price2;
	}

	public Optional<Price2> findProductBasicPrice(String productId) {
		
		return price2Repository.findByProductGetBasePrice(productId);
	}
	
	public Optional<Price2> genericDiscount() {
		return price2Repository.findGeneniricPrice();
	}

	

	
	
//	public void leftJoin() {
//		List<Price2> price2 = price2Repository.findProduct();
//		
//	}
}
