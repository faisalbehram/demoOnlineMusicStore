package com.onlinemusicstore.app.controller.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.models.CustomerOrder;
import com.onlinemusicstore.app.models.Price2;
import com.onlinemusicstore.app.models.PricesWithDiscount;
import com.onlinemusicstore.app.models.Product;
import com.onlinemusicstore.app.service.CustomerOrderService;
import com.onlinemusicstore.app.service.CustomerService;
import com.onlinemusicstore.app.service.Price2Service;
import com.onlinemusicstore.app.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService proService;

	@Autowired
	private Price2Service price2Service;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerOrderService customerOrderService;

	private Path path;

	@GetMapping("/home")
	public String adminPage() {
		System.out.println("in admin home");
		return "admin.jsp";
	}

	
	@RequestMapping("/productInventory")						// show product Inventry page
	public String productinventory(Model model) {
		List<Product> products = proService.getAllPro();

		
		model.addAttribute("products", products);
		
		System.out.println("the product list is " + products);
		System.out.println("the pricewith discount is " + products.size());
		
		
		List<Price2> allBasicPrice = price2Service.findAllBasicPrice();
		
		List<Price2> discountPrices = price2Service.findAllDiscountPrice();
		
		List<PricesWithDiscount> discounts  = price2Service.findDiscounts3(discountPrices); 
		
//		Optional<Price2> genericDiscount = price2Service.findGenericDiscount();
//		
//		if(!genericDiscount.isEmpty()) {
//			
//				PricesWithDiscount pricesWithDiscount =  price2Service.getGenericDiscount(genericDiscount);
//			model.addAttribute("genericDiscount", genericDiscount);
//		}
	
		
		
		System.out.println("the size of allBasicPrice + " + allBasicPrice.size());
		System.out.println("the size of allDiscountPrices + " + discountPrices.size());

//		List<Price2> discountG = price2Service.pricesList();
//		List<Price2> price = price2Service.pricesList();
		
		model.addAttribute("basicPrice", allBasicPrice);
		model.addAttribute("discountPrices", discountPrices);
		model.addAttribute("discounts", discounts);
		
//		model.addAttribute("discountPrice", discountPrices);
			
		return "productInventory.jsp";
	}

	// show add product Page
	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {

		model.addAttribute("product", new Product());
		
		return "../addProduct2.jsp";
	}

	// adding the product to database
	@RequestMapping(value = "/productInventory/addProductto", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			@RequestParam("productImage") MultipartFile productImage,@RequestParam("basePrice") double basePrice,
			HttpServletRequest request)
		{

			System.out.println("prducATIOM IMAGE IS " + productImage);
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "\\resources\\images\\" + product.getProductId() + ".png");

		try 
		{
			System.out.println("in try" + path);
			productImage.transferTo(new File(path.toString()));
		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
			throw new RuntimeException("Product image saving failed", e);
		}

			proService.saveProduct(product);
			
			Price2 price = new Price2();
	
			List<Price2> priceId = price2Service.findbyProductId(product.getProductId());  // this for those product who havent any price yet so if have to add price first
																							// check the product is present or not in pricing table
			System.out.println("price is  " + priceId);
	
			System.out.println("out of if condition");
			
			price.setProduct(product);
			price.setPrice(basePrice);
			System.out.println("the product is about to saved and priceing saveing is start");
			
			price2Service.saveThePrice(price);


			return "redirect:/admin/productInventory";
	}

	// delete the product 
	@RequestMapping("/productInventory/delete/{productId}")
	public String delete(@PathVariable String productId, HttpServletRequest request) {
			System.out.println("deleting");
	
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "\\resources\\images\\" + productId + ".png");
	
			if (Files.exists(path)) 
			{
				try {
					System.out.println("file exist");
					Files.delete(path);
	
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("not deleted the path file ", e);
				}
			}
	
			proService.deleteProduct(productId);
			
			System.out.println("donee");
			return "redirect:/admin/productInventory";
	}

	// edit the product page
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) 
	{
		Product product = proService.getProById(id);
		
		System.out.println("in edit product the product is " + product);
		
		model.addAttribute("product", product);
		
		System.out.println("in edit product");
		
		return "../editProduct.jsp";
	}

	// edit the product page posting to address
	
	@RequestMapping(value = "/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") Product product, Model model,
			@RequestParam("productImage") MultipartFile productImage, @RequestParam("price") double basePrice,HttpServletRequest request) {
		System.out.println("product id is " + product.getProductId());

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		path = Paths.get(rootDirectory + "\\resources\\images\\" + product.getProductId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("Product image saving failed", e);
			}
		}

			System.out.println("stringstring");
	
			System.out.println("the orignal price is " + basePrice);
			
	
			System.out.println("the product is about to saving");
	
			proService.editProduct(product);
			Price2 price = new Price2();
	
			// this for those product who haven't any price yet so if have to add price first
			// check the product is present or not in pricing table
			
			List<Price2> priceId = price2Service.findbyProductId(product.getProductId());
			System.out.println("price is  " + priceId);
			
			// if present then update the price with the discount
			// if not create with new id
			
//			if (!priceId.isEmpty()) {
//				System.out.println("in of if condition");
//				price.setId(product.getPrice2().getId());
//			}
	
			System.out.println("out of if condition");
			price.setProduct(product);
			price.setPrice(basePrice);
			System.out.println("the product is about to saved and priceing saveing is start");
			price2Service.saveThePrice(price);
	
		return "redirect:/admin/productInventory";
	}

	// search product by using the name
	@RequestMapping("/searchproduct")
	public String product(Model model, @RequestParam("productName") String name) {
		model.addAttribute("products", proService.getProductByName(name));
		System.out.println("in search the product name is " + name);
		return "productInventory.jsp";
	}

	// show all customer
	@RequestMapping("/customer")
	public String customerManagement(Model model) {

		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);

		return "customerManagement.jsp";
	}
	
	// show all order
	@RequestMapping("/order")
	public String OrderManagment(Model model) {
		System.out.println("in the Order manangement ");
		List<CustomerOrder> listOfOrder = customerOrderService.listOfCustomer();
		model.addAttribute("orders", listOfOrder);
		return "orderManagement.jsp";
		
	}

}
