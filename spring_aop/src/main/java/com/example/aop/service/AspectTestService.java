package com.example.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AspectTestService {
    public void call(String call){
        log.info("AspectTestService call 메소드 호출");
    }
}
