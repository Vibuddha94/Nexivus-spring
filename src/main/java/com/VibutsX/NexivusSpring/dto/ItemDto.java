package com.VibutsX.NexivusSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
}
