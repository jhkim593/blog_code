package com.example.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemCreateDto {
    private Long itemId;
    private int count;
}
