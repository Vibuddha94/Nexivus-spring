package com.VibutsX.NexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VibutsX.NexivusSpring.entity.CategoryEntity;
import com.VibutsX.NexivusSpring.repository.CategoryRepository;
import com.VibutsX.NexivusSpring.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    
}
