package com.VibutsX.NexivusSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VibutsX.NexivusSpring.entity.ItemEntity;



@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long>{
     
}
