package com.example.jpa.controller;

import com.example.jpa.service.OrderService;
import com.example.jpa.dto.OrderCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity createOrder(@RequestBody OrderCreateDto createDto){
        orderService.createOrder(createDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("api/0/orders")
    public ResponseEntity getOrder0(){
        orderService.getOrder0();
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/1/orders")
    public ResponseEntity getOrder1(){
        orderService.getOrder1();
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/2/orders")
    public ResponseEntity getOrder2(){
        orderService.getOrder2();
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/3/orders")
    public ResponseEntity getOrder3(@RequestParam int offset , @RequestParam int limit){
        orderService.getOrder3(offset,limit);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/4/orders")
    public ResponseEntity getOrder4(){
        orderService.getOrder4();
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/5/orders")
    public ResponseEntity getOrder5(@RequestParam int offset , @RequestParam int limit){
        orderService.getOrder5(offset,limit);
        return new ResponseEntity(HttpStatus.OK);
    }
}

