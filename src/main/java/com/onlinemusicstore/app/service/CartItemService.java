package com.onlinemusicstore.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemusicstore.app.dao.CartItemDao;
import com.onlinemusicstore.app.models.CartItem;

/**
 * Created by Le on 1/25/2016.
 */

@Service
public class CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    
    public void addCartItem(CartItem cartItem) 
    {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }
    
    public void removeCartItem2(int cartItem) {
    	System.out.println("the cartitem id is in service " + cartItem);
        cartItemDao.removeCartItembyId(cartItem);;
    }
    

    public void removeAllCartItems(int cartId){
    	cartItemDao.removeByCartId(cartId);
    }

    public CartItem getCartItemByProductId (String productId) {
    	System.out.println("in getcartbyId" + productId);
    	CartItem cartItembyPro = cartItemDao.getCartItemByProductId(productId);
    	System.out.println("in getcartbyId" + cartItembyPro);
        return cartItembyPro;
    }
    
    public List<CartItem> findAllItems(){
    	return cartItemDao.showAll();
    }
   
    public List<CartItem> showCart(int cartId){
    	return cartItemDao.showMyCart(cartId);
    }

	public CartItem getItemById(int cartItemId) {
		return cartItemDao.getItemById(cartItemId);
	}
    
}
