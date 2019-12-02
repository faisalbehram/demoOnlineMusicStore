package com.onlinemusicstore.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemusicstore.app.models.Price2;
import com.onlinemusicstore.app.models.PricesWithDiscount;
import com.onlinemusicstore.app.models.Product;
import com.onlinemusicstore.app.service.Price2Service;
import com.onlinemusicstore.app.service.ProductService;

@Controller
public class ProductController {
	
	// this is product controller which is used to update the product and product list for user
	// also to search the cart
	
	@Autowired
	private ProductService proService;	
	
	@Autowired
	private Price2Service price2Service;


	
	// show product Inventry page
		@RequestMapping("/productList")
		public String productinventory(Model model) {
			
			List<Product> products = proService.getAllPro();
			//	List<Price2> getAllPrices = price2Service.pricesList();
				
				model.addAttribute("products", products);
				
				System.out.println("the product list is " + products);
				System.out.println("the pricewith discount is " + products.size());
			
			
			System.out.println("now to display the page");
			
			// all basic prices
			List<Price2> allBasicPrice = price2Service.findAllBasicPrice();
			
			// all discount prices mean that it will fetch all that product which have discounts
			List<Price2> allDiscountPrice = price2Service.findAllDiscountPrice();	
			
			// findDiscounts will done all the discounts function for thats products which id are prsensted related to discount type
			List<PricesWithDiscount> discounts  = price2Service.findDiscounts3(allDiscountPrice);
			
			System.out.println("the size of allBasicPrice + " + allBasicPrice.size());
			System.out.println("the size of allDiscountPrices + " + allDiscountPrice.size());

			model.addAttribute("basicPrice", allBasicPrice);
			model.addAttribute("discountPrice", allDiscountPrice);
			model.addAttribute("discounts", discounts);
				
			return "productList.jsp";
		}
	
	
	
	
	
	@RequestMapping("viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
		
        Product product = proService.getProById(productId);
        model.addAttribute(product);
        
        // it will fetch the discounts by product id for single item
        PricesWithDiscount discountPrice =    price2Service.getDiscountById(productId);
        model.addAttribute("discountPrice", discountPrice);
     
           
        System.out.println("to show the pagex the discount is " + discountPrice);
        return "../viewProduct.jsp";
    }
	
	 @RequestMapping("/productListcat")
	    public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
	        List<Product> products = proService.getAllPro();
	        model.addAttribute("products", products);
	        model.addAttribute("searchCondition", searchCondition);

	        return "productList";
	    }


}
