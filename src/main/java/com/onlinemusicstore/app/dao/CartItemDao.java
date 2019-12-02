package com.onlinemusicstore.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.Cart;
import com.onlinemusicstore.app.models.CartItem;
import com.onlinemusicstore.app.repository.CartItemRepository;

@Repository
public class CartItemDao {

	@Autowired
	private CartItemRepository cartItemRepo;
	
	public void addCartItem(CartItem cartItem) 
	{
		cartItemRepo.save(cartItem);	
	}

	public void removeCartItem(CartItem cartItem) 
	{
		cartItemRepo.delete(cartItem);	
	}
	
	public void removeCartItembyId(int cartItemId) 
	{
		System.out.println("the deleted is "  );
		
//		CartItem cartItem = cartItemRepo.findByCartItemId(cartItemId);
//		System.out.println("the cartitem id is sss " + cartItemId + "/// the card id" + cartItem.getCartItemId());
		
	//	cartItemRepo.deleteById(cartItemId);
		cartItemRepo.deleteCartItem(cartItemId);
		System.out.println("deleted ");	
	}

	public CartItem getCartItemByProductId(String productId) 
	{
		System.out.println("in getcartItemby Product id " + productId);
		CartItem cartItemByPro =cartItemRepo.findByProduct(productId);
		System.out.println("in getcartItemby product is id " + cartItemByPro);
		return cartItemByPro;
		
	}

	public void removeAllCartItems(Cart cart) 
	{
		cartItemRepo.deleteAll();
	}
	
	public void removeByCartId(int cartId) 
	{
		System.out.println("in the cartItemDao is removie by cartId ");
		cartItemRepo.deleteCartItemByCartId(cartId);	
	}
	
	public List<CartItem> showAll()
	{
		List<CartItem> cartItems = cartItemRepo.findAll();
		return cartItems;
	}

	public List<CartItem> showMyCart(int cartId) 
	{
		System.out.println("in show my cart where card id is " + cartId);
		
		String cartIdd = new StringBuilder().append(cartId).toString();
		System.out.println("in show my cart where card id iss in string " + cartIdd);
		
		List<CartItem> cartItems = cartItemRepo.findByCart(cartId);
		System.out.println("the cart item is " + cartItems);
		return cartItems;
	}
//	public List<CartItem> showMyCart(Cart cartId) {
//		System.out.println("in show my cart where card id is " + cartId);
//		
//		String cartIdd = new StringBuilder().append(cartId).toString();
//		System.out.println("in show my cart where card id iss in string " + cartIdd);
//		
//		List<CartItem> cartItems = cartItemRepo.findByCart(cartId);
//		System.out.println("the cart item is " + cartItems);
//		return cartItems;
//	}

	public CartItem getItemById(int cartItemId) 
	{
		CartItem cartItem = cartItemRepo.findByCartItemId(cartItemId);
		System.out.println("the cartitem id is in DAO " + cartItem.getCartItemId());
		return cartItem;
	}


	
	

}
