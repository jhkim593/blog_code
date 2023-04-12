package com.example.jpa.controller;

import com.example.jpa.dto.OrderCreateDto;
import com.example.jpa.service.InitService;
import com.example.jpa.service.OrderService;
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
public class InitController {
    private final InitService initService;

    @GetMapping("/api/0/init")
    public ResponseEntity init0(){
        initService.init();
        return new ResponseEntity(HttpStatus.OK);
    }
}

