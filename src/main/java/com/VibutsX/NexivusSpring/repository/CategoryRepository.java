package com.VibutsX.NexivusSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VibutsX.NexivusSpring.entity.CategoryEntity;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
    
}
