package com.VibutsX.NexivusSpring.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDateTime;

    @Column(nullable = false)
    private Double orderTotal;

    @PrePersist
    protected void onCreate(){
        if (this.orderDateTime == null) {
            this.orderDateTime = LocalDateTime.now();
        }
    }

    @ManyToMany
    @JoinTable(
        name = "order_Item",
        joinColumns = @JoinColumn(name = "order_Id" ,referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "item_Id" , referencedColumnName = "id")
    )
    private List<ItemEntity> items;

    
}
