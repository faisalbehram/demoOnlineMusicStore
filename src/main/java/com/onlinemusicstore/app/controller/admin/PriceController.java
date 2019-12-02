package com.onlinemusicstore.app.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemusicstore.app.models.Price2;
import com.onlinemusicstore.app.models.PricesWithDiscount;
import com.onlinemusicstore.app.models.Product;
import com.onlinemusicstore.app.service.Price2Service;
import com.onlinemusicstore.app.service.ProductService;

@Controller
@RequestMapping("/admin")
public class PriceController {
	
	@Autowired
	private Price2Service price2Service;
	
	@Autowired
	private ProductService proService;


	/*
		this is pricing controller from admin which is controlled by admin
		
	*/	
	@RequestMapping("/pricing")
	public String pricing(Model model) {
		
		List<Product> products = proService.getAllPro();
		List<Price2> discountPrices = price2Service.findAllDiscountPrice();
		List<Price2> basePrices = price2Service.findAllBasicPrice();
		List<PricesWithDiscount> discounts  = price2Service.findDiscounts3(discountPrices);

		Optional<Price2> genericDiscount = price2Service.findGenericAllDiscount();
		
		model.addAttribute("products", products);
		model.addAttribute("discountPrices", discountPrices);
		model.addAttribute("listOfBasePrices", basePrices);
		model.addAttribute("discounts", discounts);
		model.addAttribute("genericDiscount", genericDiscount);
		
		return "priceing.jsp";
	}
	
	@RequestMapping(value = "/pricing",method = RequestMethod.POST)
	public String savePrcing(Model theModel,@RequestParam(value = "percentageDiscount", required = false, defaultValue = "0")double percentageDiscount
			,@RequestParam("product") Product product,@RequestParam("basePrice") double basePrice) {
		
		Price2 price2 = new Price2();

		// this for those product who havent any price yet so if have to add price first
		// check the product is present or not in pricing table
		
		List<Price2> priceId = price2Service.findbyProductId(product.getProductId());
		
		
		System.out.println("price is  " + priceId);
		// if present then update the price with the discount
		// if not create with new id
		
		if (!priceId.isEmpty()) {
			System.out.println("in of if condition and the id is " + priceId );
			price2.setId(product.getPrice2().get(1).getId());
		}
		System.out.println("out of if condition");
		price2.setProduct(product);
		System.out.println( "in percentageDiscount " + percentageDiscount + "/// the id is" + product);
		
		price2.setPercentageDiscount(percentageDiscount);
		
		price2.setProduct(product);
		
		price2.setPercentageDiscount(percentageDiscount);
		
		price2.setPrice(basePrice);
		
		price2Service.saveThePrice(price2);
		
		return "admin.jsp";
	}
	
	
	@RequestMapping(value = "/disableDiscount" )
	public String disableDiscount(@RequestParam(value = "priceId" ,required = false) int priceId,@RequestParam( value = "priceId" ,required = false ) String productId) {
		System.out.println("in disabble discount is ");
		if(!productId.isEmpty()) {
		
		Optional<Price2> price2 = price2Service.findById(priceId);
		System.out.println("the discount is  " + price2 + "the all product is " + price2.get().getId());
		price2Service.disableThePrice(price2.get());
			
		}
		else {
			System.out.println("in else the string is all");
			
		}
		

		return "redirect:/admin/pricing";
	}

	
	@RequestMapping("/updateDiscount")
	public String UpdateDiscount(@RequestParam("discount" ) double discount ,
								@RequestParam("allProduct") String productId) {
	
		if(!productId.equals("all")) 
		{
		
				System.out.println("when All is not");
				List<Price2> price2 = price2Service.findProductPriceForUpdate(productId);
				
				if(price2.isEmpty()) {
					System.out.println("if it is empty so");
					Optional<Price2> getProductId = price2Service.findByPro(productId);
					Price2 newPrice = new Price2();
					newPrice.setProduct(getProductId.get().getProduct());
					price2Service.saveSpecilDiscount(newPrice, discount);
					return "admin.jsp";
				}
		
				System.out.println("the price2 size is to update the price2 " + price2);
				for(int i =0; i<price2.size();i++) {
					
						if(price2.get(i).getProduct().getProductId().equals(productId)) {
						
							price2Service.saveSpecilDiscount(price2, discount,i);
							break;
						}
						
				}
		
		
		}
		else 
		{
				System.out.println("checking generic if present is");
				Optional<Price2> findGenericDiscountId =price2Service.findGenericAllDiscount();
				if(findGenericDiscountId.isEmpty())
					{
					System.out.println("saving new Generic");
					price2Service.saveGenericThePrice(discount);
					}
				else {
					System.out.println("the all product generic discount is");
					
					int genericId = findGenericDiscountId.get().getId();
					System.out.println("Update  generic discount is");
					price2Service.saveGenericThePrice(discount, genericId);
					}
					
		}
		
	return "admin.jsp";	
}
}
