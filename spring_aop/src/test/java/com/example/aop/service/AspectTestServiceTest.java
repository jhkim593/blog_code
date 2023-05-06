package com.example.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AspectTestServiceTest {

    @Autowired
    AspectTestService aspectTestService;

    @Test
    public void call(){
        log.info("isProxy : {}",AopUtils.isAopProxy(aspectTestService));
        aspectTestService.call("call");
    }
}