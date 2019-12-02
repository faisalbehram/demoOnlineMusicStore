package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemusicstore.app.models.BillingAddress;

public interface BillingRepository extends JpaRepository<BillingAddress, Integer> {

}
