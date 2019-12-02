package com.onlinemusicstore.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemusicstore.app.models.Cart;
import com.onlinemusicstore.app.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	
	@Query("SELECT a FROM CartItem a WHERE a.product= 'p33'")
	CartItem findByProduct(@Param("productId")String productId);

	@Query("FROM CartItem WHERE cart='9'")
	List<CartItem> findCart(Cart cartId);
	
	@Query("SELECT a FROM CartItem a WHERE a.cart.cartId= :cart")
	List<CartItem> findByCart(@Param("cart") int cart);
	
	@Query("SELECT a FROM  CartItem a WHERE a.cartItemId = :cartItemId ")
	CartItem findByCartItemId(@Param("cartItemId") int cartItemId);
	
	@Transactional
	@Modifying
	 @Query("DELETE  FROM  CartItem  WHERE cartItemId =?1 ") 
	 void deleteCartItem(@Param("cartItemId") int cartItemId);
	
	@Transactional
	@Modifying
	 @Query("DELETE  FROM  CartItem  WHERE cart.cartId =?1 ") 
	 void deleteCartItemByCartId(@Param("cart") int cart);

}
