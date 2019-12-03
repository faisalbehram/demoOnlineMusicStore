package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemusicstore.app.models.ShippingAddress;

public interface ShippingRepository extends JpaRepository<ShippingAddress , Integer> {

}
