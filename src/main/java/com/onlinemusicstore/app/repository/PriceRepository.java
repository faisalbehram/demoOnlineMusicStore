//package com.onlinemusicstore.app.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.onlinemusicstore.app.models.Price;
//
//public interface PriceRepository extends JpaRepository<Price, Integer>{
//
//	@Query("SELECT a FROM Price a WHERE a.product.productId= :productId")
//	List<Price> findByProductProductId(@Param("productId")String productId);
//
//	
//	
//
//}
