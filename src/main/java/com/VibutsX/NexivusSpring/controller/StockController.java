package com.VibutsX.NexivusSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibutsX.NexivusSpring.dto.StockDto;
import com.VibutsX.NexivusSpring.entity.StockEntity;
import com.VibutsX.NexivusSpring.service.ItemService;
import com.VibutsX.NexivusSpring.service.StockService;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stock")
    public ResponseEntity<List<StockEntity>> getAll() {
        List<StockEntity> stock = stockService.getAll();

        return ResponseEntity.status(200).body(stock);
    }

    @PostMapping("/stock")
    public ResponseEntity<StockEntity> create(@RequestBody StockDto dto) {  //here dto.id is item id

        StockEntity newStock = new StockEntity();

        if (itemService.getById(dto.getId()) == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            newStock.setItem(itemService.getById(dto.getId()));
            newStock.setQoh(dto.getQty());

            if (stockService.getByItem(newStock.getItem()) == null) {
                StockEntity createdStock = stockService.create(newStock);
                return ResponseEntity.status(201).body(createdStock);
            } else {
                return ResponseEntity.status(403).body(null);
            }
        }
    }

    @PutMapping("/stock/addto")
    public ResponseEntity<List<StockEntity>> addToStock(@RequestBody List<StockDto> dtos) { // here dto.id is stock id
        List<StockEntity> updatedList = new ArrayList<>();
        for (StockDto stockDto : dtos) {
            StockEntity updated = stockService.addToStock(stockDto.getId(), stockDto.getQty());
            if (updated != null) {
                updatedList.add(updated);
            } 
        }
        return ResponseEntity.status(201).body(updatedList);
    }

    @PutMapping("/stock/getfrom")
    public ResponseEntity<List<StockEntity>> getFromStock(@RequestBody List<StockDto> dtos) {
        List<StockEntity> updatedList = new ArrayList<>();
        for (StockDto stockDto : dtos) {
            StockEntity updated = stockService.getFromStock(stockDto.getId(), stockDto.getQty());
            if (updated != null) {
                updatedList.add(updated);
            } 
        }
        return ResponseEntity.status(201).body(updatedList);
    }

    @PutMapping("/stock")
    public ResponseEntity<StockEntity> updateStock(@RequestBody StockDto dto) {
        
        StockEntity updatedStock = stockService.updateStock(dto.getId(), dto.getQty());

        if (updatedStock == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updatedStock);
        }
    }
}
