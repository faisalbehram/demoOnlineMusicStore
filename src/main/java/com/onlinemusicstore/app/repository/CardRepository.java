package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemusicstore.app.models.BillingAddress;
import com.onlinemusicstore.app.models.Cart;

public interface CardRepository extends JpaRepository<Cart, Integer> {
	

}
