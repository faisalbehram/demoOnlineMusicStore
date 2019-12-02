package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemusicstore.app.models.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

}
