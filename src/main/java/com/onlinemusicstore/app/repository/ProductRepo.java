package com.onlinemusicstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemusicstore.app.models.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	@Query("FROM Product  WHERE productId =?1")
	Product findByProductId(@RequestParam("productId") String id);

	List<Product> findByProductNameLike(String productName);
	
//	@Query("SELECT * FROM Product")
//	List<Product> findAllProduct();
}
