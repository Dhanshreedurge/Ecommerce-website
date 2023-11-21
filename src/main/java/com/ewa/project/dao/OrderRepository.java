package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByOrderId(Long OrderId);
    
}
