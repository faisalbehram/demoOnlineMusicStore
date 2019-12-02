package com.onlinemusicstore.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemusicstore.app.dao.CartDao;
import com.onlinemusicstore.app.models.Cart;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public Cart getCartbyId(int cartId) {
		return cartDao.getCartById(cartId);
	}

	
	public void updateTheCart(Cart cart,Double totalPrice) {
			System.out.println("in CartService Update " + cart +  " and the price is " + totalPrice);
			 cartDao.UpdateCart(cart,totalPrice);
			
	}

}
