package com.VibutsX.NexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VibutsX.NexivusSpring.entity.OrderEntity;
import com.VibutsX.NexivusSpring.repository.OrderRepository;
import com.VibutsX.NexivusSpring.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity create(OrderEntity entity) {
        return orderRepository.save(entity);
    }
    
}
