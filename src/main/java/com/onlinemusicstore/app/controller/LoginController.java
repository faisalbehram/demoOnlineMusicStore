package com.onlinemusicstore.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	 @GetMapping("/login")
	    public String login(@RequestParam (value="error", required = false) String error,
	                        @RequestParam (value="logout", required = false) String logout, Model model
	                        ) {

	        if(error != null) {
	            model.addAttribute("error", "Invalid username and password!");
	        }

	        if(logout!= null) {
	            model.addAttribute("msg", "You have been logged out successfully.");
	        }

	        return "login.jsp";
	    }
	
//	@GetMapping("/login")
//	public String loignpage() {
//		System.out.println("in login");
//		return "login.jsp";
//	}

	
	
//	 
//	 @RequestMapping(value = "/register")
//	 public String registerUser(Customer customer,Model model) {
//		 model.addAttribute("customer",customer);
//		 
//		 return "registerCustomer.jsp";
//	 } 	
	 
	 
	 
	 
	 
//
//	@RequestMapping("/login2")
//	public String login2() {
//		return "login2.jsp";
//	}


}
