package com.example.jpa.dto;

import com.example.jpa.entity.Address;
import com.example.jpa.entity.Order;
import com.example.jpa.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private String memberName;
    private OrderStatus orderStatus;
    private Address address;
    private LocalDateTime orderDate;


    public static OrderDto createOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.orderId = order.getId();
        orderDto.memberName = order.getMember().getName();
        orderDto.orderDate = order.getOrderDate();
        orderDto.orderStatus = order.getStatus();
        orderDto.address = order.getDelivery().getAddress();
//        orderItems = order.getOrderItems().stream()
//                .map(orderItem -> new OrderItemDto(orderItem))
//                .collect(toList());
        return orderDto;
    }
}
