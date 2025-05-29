package com.VibutsX.NexivusSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibutsX.NexivusSpring.dto.OrderDto;
import com.VibutsX.NexivusSpring.entity.ItemEntity;
import com.VibutsX.NexivusSpring.entity.OrderEntity;
import com.VibutsX.NexivusSpring.service.ItemService;
import com.VibutsX.NexivusSpring.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderEntity>> getAll() {
        List<OrderEntity> orders = orderService.getAll();

        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderEntity> create(@RequestBody OrderDto dto) {

        OrderEntity newOrder = new OrderEntity();
        Double total = 0.0;
        List<ItemEntity> orderItems = new ArrayList<ItemEntity>();

        for (Long id : dto.getItemIds()) {
            ItemEntity item = itemService.getById(id);
            if (item != null) {
                orderItems.add(item);
                total += item.getPrice();
            }
        }

        newOrder.setItems(orderItems);
        newOrder.setOrderTotal(total);

        OrderEntity createdOrder = orderService.create(newOrder);

        return ResponseEntity.status(201).body(createdOrder);
    }

}
