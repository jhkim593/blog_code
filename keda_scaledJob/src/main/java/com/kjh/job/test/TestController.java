package com.kjh.job.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final MQListener mqListener;
    @GetMapping("/get/status")
    public ResponseEntity status(){
        return new ResponseEntity(mqListener.getStatus().name(),HttpStatus.OK);
    }
}
