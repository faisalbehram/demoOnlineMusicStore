package com.onlinemusicstore.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.Cart;
import com.onlinemusicstore.app.repository.CardRepository;

@Repository
public class CartDao {
	
	@Autowired
	private CardRepository cartRepository;
	// saving the cart
	
	public void saveCart(Cart cart) {
	
		cartRepository.save(cart);
		System.out.println("the cart are saved");	
	}
	
	
	public Cart getCartById(int cartId) {
		return cartRepository.findById(cartId).orElseThrow();
	}

	public void UpdateCart(Cart cart,Double totalPrice) {
		if(totalPrice == 0.0) {
			Cart cart2 = cartRepository.findById(cart.getCartId()).orElseThrow();
			System.out.println(" in IF the price is  " + totalPrice + " // and the id is " + cart2 );
			cart2.setGrandTotal(totalPrice);
			cartRepository.save(cart2);	
			
		}
		else
		{
			Cart cart2 = cartRepository.findById(cart.getCartId()).orElseThrow();
			System.out.println("the price is in cartDao " + totalPrice + " // and the id is " + cart2 );
			double newprice  = totalPrice +  cart2.getGrandTotal();
			System.out.println("the new price is " + newprice + "and the cart2 privce price is  " + cart2.getGrandTotal());
			cart2.setGrandTotal(newprice);
			cartRepository.save(cart2);	
		}
	}
	
//	public Cart Update(Cart cart)
//	{
//		int cartId = cart.getCartId();
//		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
//		cart.setGrandTotal(grandTotal);
//		return cartRepository.save(cart);
//	}
	

}
