package com.example.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDto {

    private Long memberId;
    private List<OrderItemCreateDto> orderItems;

}
