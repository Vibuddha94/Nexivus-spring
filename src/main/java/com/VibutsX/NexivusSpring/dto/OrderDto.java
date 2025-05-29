package com.VibutsX.NexivusSpring.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    List<Long> itemIds;
}
