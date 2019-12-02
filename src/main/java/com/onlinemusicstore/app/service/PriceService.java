//package com.onlinemusicstore.app.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.onlinemusicstore.app.dao.PriceDao;
//import com.onlinemusicstore.app.models.Price;
//
//@Service
//public class PriceService {
//	
//	@Autowired
//	private PriceDao priceDao;
//	
////	public void SavePrice(Price price) {
////		
////		double  discount,orignalPrice,s;
////			
////		
////		// discount and orignal are taken from the class
////		 discount = price.getPercentageDiscount();
////		System.out.println("the discount is " + discount);
////		
////		 orignalPrice = price.getOrignalPrice();
////		System.out.println("the orignalprice is " + orignalPrice);
////		
////		// divide  the discount with  100  
////		double discountwith = discount/100;
////		System.out.println("the discountwith is " + discountwith);
////		
////		// now the multiply the orignal with the discountwith 
////		double orignalPrice2= orignalPrice * discountwith;
////		System.out.println("the orignalprice2 is " + orignalPrice2);
////		
////		// now subtract the discount price from orignal;
////		double discountPrice = orignalPrice-orignalPrice2;
////		System.out.println("the discountprice is " + discountPrice);
////		
////		price.setOrignalPrice(orignalPrice);
////		price.setPercentageDiscount(discount);
////		price.setDiscountPrice(discountPrice);
////		
////		priceDao.savePrice(price);
////	}
//
//	public List<Price> findbyProductId(String productId) {
//		System.out.println("the product id in priceservice is " + productId);
//		List<Price> price = priceDao.findByProductId(productId);
//		return price;
//	}
//
//	public void saveTheProduct(double orignalPrice, double discount, Price price) {
//		 
//		// the generic discount is 5% to all those product who havent any discount
//		 double genericDiscount = 5;
//		 
//		  price.setOrignalPrice(orignalPrice);
//		  
//		  if(discount == 0) {
//			  price.setGenericDiscount(genericDiscount);
//			  double discountwith = genericDiscount/100;
//			  double orignalPrice2= orignalPrice * discountwith;
//			  double discountPrice = orignalPrice-orignalPrice2;
//			  price.setGenericDiscountPrice(discountPrice);
//			  price.setDiscountPrice(discountPrice);
//			  priceDao.savePrice(price);
//			  
//		  }else
//		  {
//	      	price.setPercentageDiscount(discount);  
//	     	
//			// discount and orignal are taken from the class
////			 discount = price.getPercentageDiscount();
//			System.out.println("the discount is " + discount);
////			
////			 orignalPrice = price.getOrignalPrice();
//			System.out.println("the orignalprice is " + orignalPrice);
////			
//			// divide  the discount with  100  
//			double discountwith = discount/100;
//			System.out.println("the discountwith is " + discountwith);
//			
//			// now the multiply the orignal with the discountwith 
//			double orignalPrice2= orignalPrice * discountwith;
//			System.out.println("the orignalprice2 is " + orignalPrice2);
//			
//			// now subtract the discount price from orignal;
//			double discountPrice = orignalPrice-orignalPrice2;
//			System.out.println("the discountprice is " + discountPrice);
//			
//			price.setDiscountPrice(discountPrice);
//			priceDao.savePrice(price);
//	      
//		  } 
//		
//	}
//	
//	
//
//}
