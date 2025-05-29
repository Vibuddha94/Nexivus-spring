package com.VibutsX.NexivusSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibutsX.NexivusSpring.entity.CategoryEntity;
import com.VibutsX.NexivusSpring.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryEntity>> getAll() {
        List<CategoryEntity> categories = categoryService.getAll();

        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity entity) {
        CategoryEntity createdCategory = categoryService.createCategory(entity);

        return ResponseEntity.status(201).body(createdCategory);
    }

}
