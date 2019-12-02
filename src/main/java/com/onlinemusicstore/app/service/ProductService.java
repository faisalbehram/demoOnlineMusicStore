package com.onlinemusicstore.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemusicstore.app.models.Product;
import com.onlinemusicstore.app.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo proRepo;
	
	public List<Product> getAllPro(){
		System.out.println("getallpro");
		return proRepo.findAll();
	}
	
	public void saveProduct(Product product) {
		System.out.println("saving");
		proRepo.save(product);
		System.out.println("saved");
	}
	
	public Product getProById(String id) {
		
		System.out.println("in productById is id + " + id );
	Product pro = proRepo.findByProductId(id);
	System.out.println("in productById is + " + pro );
	return pro;
	}
	
	public List<Product> getProductByName(String productName) {
		
		System.out.println("in productById is id + " + productName );
	List<Product> pro = proRepo.findByProductNameLike("%"+productName+"%");
	System.out.println("in productById is + " + pro );
	return pro;
	}
	
	public void deleteProduct(String id) {
		proRepo.deleteById(id);
	}

	public void editProduct(Product product) {
		System.out.println("edit is saving");
		proRepo.save(product);
		System.out.println("edit is saved");
		
	}

	
}
