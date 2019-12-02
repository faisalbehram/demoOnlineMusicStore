package com.onlinemusicstore.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemusicstore.app.models.Price2;

public interface Price2Repository extends JpaRepository<Price2, Integer>{

	@Query("SELECT a FROM Price2 a WHERE a.product.productId= :productId")
	List<Price2> findByProductProductId(@Param("productId")String productId);
	
	@Query("SELECT a FROM Price2 a WHERE a.product.productId= :productId AND a.priceType = 'Discount' ")
	List<Price2> findProductPriceForUpdate(@Param("productId")String productId);
	
	
	
	
	@Query("SELECT a FROM Price2 a WHERE a.product.productId= :productId")
	Optional<Price2> findProduct(@Param("productId")String productId);
	
	
	// the below quries run in new priceing verion3	
	
	// to get discount price by id
	@Query("SELECT a FROM Price2 a WHERE a.product.productId= :productId AND a.toDate IS NULL AND a.priceType = 'Discount' ")
	Optional<Price2> findByProductForViewProductDiscount(@Param("productId")String productId);
	
	// to get basic price by product it
	@Query("SELECT a FROM Price2 a WHERE a.product.productId= :productId AND a.toDate IS NULL AND a.priceType = 'Basic' ")
	Optional<Price2> findByProductGetBasePrice(@Param("productId")String productId);
	
	//all product basic price
	@Query("SELECT a FROM Price2 a WHERE  a.toDate  IS NULL AND a.priceType = 'Basic'")
	List<Price2> findAllBasicPrice();
	
	// all product which have disocunt with there product id
	@Query("SELECT a FROM Price2 a WHERE  a.toDate  IS NULL AND a.priceType = 'Discount'  AND a.product IS NOT NULL")
	List<Price2> findAllDiscountPrice();
	
	@Query("SELECT a FROM Price2 a WHERE  a.toDate  IS NULL AND a.priceType = 'Discount' AND a.product IS NULL")
	Optional<Price2> findGeneniricPrice();

	@Query("SELECT a FROM Price2 a WHERE a.id = id AND a.toDate  IS NULL AND a.priceType = 'Discount'")
	Optional<Price2> findByPriceId(@RequestParam("priceId")int id);
	

	
	
}
