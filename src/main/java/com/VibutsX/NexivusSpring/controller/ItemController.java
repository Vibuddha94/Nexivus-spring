package com.VibutsX.NexivusSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibutsX.NexivusSpring.dto.ItemDto;
import com.VibutsX.NexivusSpring.entity.ItemEntity;
import com.VibutsX.NexivusSpring.service.CategoryService;
import com.VibutsX.NexivusSpring.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemEntity>> getAll() {

        List<ItemEntity> items = itemService.getAll();

        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemDto dto) {
        ItemEntity newItem = new ItemEntity();
        if (categoryService.getById(dto.getCategoryId()) == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            newItem.setName(dto.getName());
            newItem.setDescription(dto.getDescription());
            newItem.setPrice(dto.getPrice());
            newItem.setCategory(categoryService.getById(dto.getCategoryId()));

            ItemEntity createdItem = itemService.createItem(newItem);

            return ResponseEntity.status(201).body(createdItem);
        }
    }

    @PutMapping("items/{id}")
    public ResponseEntity<ItemEntity> update(@PathVariable Long id, @RequestBody ItemDto dto) {
        ItemEntity newItem = new ItemEntity();
        if (categoryService.getById(dto.getCategoryId()) == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            newItem.setName(dto.getName());
            newItem.setDescription(dto.getDescription());
            newItem.setPrice(dto.getPrice());
            newItem.setCategory(categoryService.getById(dto.getCategoryId()));

            ItemEntity updatedItem = itemService.update(id, newItem);

            return ResponseEntity.status(201).body(updatedItem);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (itemService.getById(id) == null) {
            return ResponseEntity.status(404).body("Item Not Found");
        } else {
            itemService.delete(id);
            return ResponseEntity.status(200).body("Item Deleted");
        }

    }

}
