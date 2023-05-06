package com.example.aop.dynamicProxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestService {
    public void call(){
        log.info("AspectTestService call 메소드 호출");
    }
}

