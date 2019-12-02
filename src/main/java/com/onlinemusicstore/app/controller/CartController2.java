package com.onlinemusicstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinemusicstore.app.models.Cart;
import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController2 {

    @Autowired
    private CustomerService customerService;


    // adding items to card... such that the item is saved on specific customer email
    // here we just got the email of customer and get there id from email to show the cart 
    @RequestMapping("/{email}")
    public String getCartRedirect(@PathVariable (value = "email") String email) {
    	
    	System.out.println(" in{ email} cartcontroller2  ");
    	
    	// get customer by Email
    	Customer customer = customerService.getCustomerByEmail(email);
    	
    	System.out.println("the customer is in cartcontroller2  "+  customer);
    	
    	// take card id from customer
    	int cartId  = customer.getCart().getCartId();
    	
    	// get the cart
    	Cart cart  = customer.getCart();

    	
    	//if(cartId == customer.getCart().getCartId())
    	System.out.println("in redirect link2" + cart);
    	
        return "redirect:/showcart/"+ cartId;
    }
    
    
    

}
