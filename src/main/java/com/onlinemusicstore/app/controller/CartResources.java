package com.onlinemusicstore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinemusicstore.app.models.Cart;
import com.onlinemusicstore.app.models.CartItem;
import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.models.PricesWithDiscount;
import com.onlinemusicstore.app.models.Product;
import com.onlinemusicstore.app.service.CartItemService;
import com.onlinemusicstore.app.service.CartService;
import com.onlinemusicstore.app.service.CustomerService;
import com.onlinemusicstore.app.service.Price2Service;
import com.onlinemusicstore.app.service.ProductService;

/**
 * Created by Le on 1/25/2016.
 */

@Controller
@RequestMapping("/cart")
public class CartResources {

	// this is main controller where you have to add items to cart
	// can delete items from cart
	// can clear full cart

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Price2Service price2Service;
	
	
	// to get the cart 
	
	@RequestMapping(name = "/{cartId}", method = RequestMethod.POST)
	public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartbyId(cartId);
	}

	// add the items to the cart also it show that if user are new creat a new cart id
	
	@RequestMapping(value = "/add/{email}/{productId}")
	public String addItem(@PathVariable("email") String email, @PathVariable("productId") String productId) {

		System.out.println("in additem class");

		Customer customer = customerService.getCustomerByEmail(email);

		System.out.println("customer is  is " + customer.getCustomerName());

		Cart cart = customer.getCart();

		System.out.println("cart id  is  is " + customer.getCart());
		System.out.println("product id  is  is " + productId);

		Product product = productService.getProById(productId);

		System.out.println("product id  is  is " + product);

		List<CartItem> cartItems = cart.getCartItems();

		// if already there is items in cart with same product id then just increase the quantity and grand total
		for (int i = 0; i < cartItems.size(); i++) 
		{
			if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {

				System.out.println("in  product if cart resourses");
			
				CartItem cartItem = cartItems.get(i);
				System.out.println("the cartItem id is " +cartItem.getCartItemId()  );
				
				System.out.println("the cartItem id is 1 " +cartItem.getCartItemId());
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setCart(cart);
				
				// this class is not in database this is just to hold the data  (PriceWithDiscount)
				PricesWithDiscount discountPrice  = price2Service.getDiscountById(productId);
				
				//if the discount is zero for a prpduct the apply baseprice in total price
				if(discountPrice.getDiscountPrice() ==0) {
					
					cartItem.setTotalPrice(product.getPrice2().get(i).getPrice() * cartItem.getQuantity());
				
					cartItemService.addCartItem(cartItem);
					
					cartService.updateTheCart(cart, cartItem.getTotalPrice());
					
					return "redirect:/showcart/" + cartItem.getCart().getCartId();
					
				}
				else 
				{
					cartItem.setTotalPrice(discountPrice.getDiscountPrice() * cartItem.getQuantity());
					System.out.println("the discount price is total " + cartItem.getTotalPrice() );
					cartItemService.addCartItem(cartItem);
					
					cartService.updateTheCart(cart, discountPrice.getDiscountPrice());
					
					return "redirect:/showcart/" + cartItem.getCart().getCartId();
					
				}
			}
		}
		//if there is not item in cart item table then to create a new one
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		PricesWithDiscount discountPrice  = price2Service.getDiscountById(productId);
		// again for discount is when zero
		
		if(discountPrice.getDiscountPrice() ==0 ) {
			cartItem.setTotalPrice(product.getPrice2().get(0).getPrice() * cartItem.getQuantity());
			cartItem.setCart(cart);

			System.out.println("Saving the cart items  ");
			cartItemService.addCartItem(cartItem);
			System.out.println("updateing the cart  ");
			cartService.updateTheCart(cart, cartItem.getTotalPrice());
		}
		else {
			cartItem.setTotalPrice(discountPrice.getDiscountPrice() * cartItem.getQuantity());
			cartItem.setCart(cart);

			System.out.println("Saving the cart items   + the cart item quantity is "  + cartItem.getQuantity());
			cartItemService.addCartItem(cartItem);
			System.out.println("updateing the cart  the total discount price is " +  discountPrice.getDiscountPrice() );
			cartService.updateTheCart(cart, discountPrice.getDiscountPrice());
		}
		
		

		return "redirect:/showcart/" + cartItem.getCart().getCartId();
	}
	

	// remove the cartitem from cart
	@RequestMapping(value = "/remove/{cartItemId}")
	public String removeItem(@PathVariable(value = "cartItemId") int cartItemId) {
//     	System.out.println("removing cart to the system");

		CartItem cartItem = cartItemService.getItemById(cartItemId);

		// cartItem= cartItemService.getItemById(cartItemId);

		System.out.println("removing cart to the system getthe product");

		cartItemService.removeCartItem2(cartItem.getCartItemId());
		System.out.println("removing cart to the system done");
		// return "redirect:/showcart/"+cartItemId;
		return "redirect:/showcart/" + cartItem.getCart().getCartId();
	}
	
	// clear the whole cart
	@RequestMapping(value = "/clear/{cartId}")
	public String clearCart(@PathVariable(value = "cartId") int cartId) {

		System.out.println("in clearcart the cartId is  " + cartId);

		Cart cart = cartService.getCartbyId(cartId);
		Double totalPrice = 0.0;
		cartService.updateTheCart(cart, totalPrice);
		System.out.println("in clearcart the cart is after fetching " + cart.getCartId());

		cartItemService.removeAllCartItems(cart.getCartId());

		return "redirect:/showcart/" + cartId;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
	public void handleClientErrors(Exception e) {
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
	public void handleServerErrors(Exception e) {
	}
}
