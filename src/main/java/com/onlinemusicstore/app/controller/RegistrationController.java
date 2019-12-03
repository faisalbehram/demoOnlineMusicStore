package com.onlinemusicstore.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlinemusicstore.app.models.BillingAddress;
import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.models.ShippingAddress;
import com.onlinemusicstore.app.service.CustomerService;
import com.onlinemusicstore.app.util.SendTheMail;

@Controller
public class RegistrationController {
	//this controller is used to register the customer with full information
	//
	
	@Autowired
    private CustomerService customerService;

	@Autowired
	private SendTheMail sendTheMail;
	
	 @RequestMapping("/register")
	    public String registerCustomer(Model model) {

		 System.out.println("show registeration page");
	        Customer customer = new Customer();
	        BillingAddress billingAddress = new BillingAddress();
	        ShippingAddress shippingAddress = new ShippingAddress();
	        customer.setBillingAddress(billingAddress);
	        customer.setShippingAddress(shippingAddress);

	        model.addAttribute("customer", customer);

	        return "registerCustomer.jsp";

	    }
	 
	 @RequestMapping(value = "/registercustomer", method = RequestMethod.POST)
	    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
	                                       Model model) {
		 System.out.println("posting registration");
	        if (result.hasErrors()) {
	            return "registerCustomer.jsp";
	        }

	      //  List<Customer> customerList=customerService.getAllCustomers();

//	        for (int i=0; i< customerList.size(); i++) {
//	            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
//	                model.addAttribute("emailMsg", "Email already exists");
//
//	                return "registerCustomer";
//	            }
//
//	            if(customer.getUsername().equals(customerList.get(i).getUsername())) {
//	                model.addAttribute("usernameMsg", "Username already exists");
//
//	                return "registerCustomer";
//	            }
//	        }

	   	 System.out.println("posting 2 registration");
	        customer.setEnabled(true);
	        sendTheMail.mailSending(customer.getCustomerEmail());
		   	 
	   	 System.out.println("posting 3registration");
	        customerService.addCustomer(customer);
	   	 System.out.println("posting4 registration");
	   	 
	   	 sendTheMail.mailSending(customer.getCustomerEmail());
	   	 

	        return "registerCustomerSuccess.jsp";

	    }
	 
	 
//	 @RequestMapping("/saveuser")
//	 public String saveUser() {
//		 
//		 usersDao.saveing();
//		 System.out.println("done");
//		 return "doneeee";
//		 
//	 }


}
