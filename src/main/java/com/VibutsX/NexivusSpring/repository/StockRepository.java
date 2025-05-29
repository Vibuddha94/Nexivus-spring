package com.VibutsX.NexivusSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VibutsX.NexivusSpring.entity.ItemEntity;
import com.VibutsX.NexivusSpring.entity.StockEntity;





@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {
    Optional<StockEntity> findByItem(ItemEntity item);
}
