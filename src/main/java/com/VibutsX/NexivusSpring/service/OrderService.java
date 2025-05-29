package com.VibutsX.NexivusSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VibutsX.NexivusSpring.entity.OrderEntity;

@Service
public interface OrderService {
    List<OrderEntity> getAll();
    OrderEntity create(OrderEntity entity);
}
