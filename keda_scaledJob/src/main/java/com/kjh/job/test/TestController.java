package com.kjh.job.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final MQListener mqListener;

    @GetMapping("/api/status")
    public ResponseEntity status(){
        mqListener.setStatus(MQListener.Status.IDLE);
        return new ResponseEntity(HttpStatus.OK);
    }
}
