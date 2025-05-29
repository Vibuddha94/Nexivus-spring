package com.VibutsX.NexivusSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VibutsX.NexivusSpring.entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    
}
