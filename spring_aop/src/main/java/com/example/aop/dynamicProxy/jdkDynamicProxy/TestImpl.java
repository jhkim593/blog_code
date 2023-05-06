package com.example.aop.dynamicProxy.jdkDynamicProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestImpl implements TestAInterface {
    @Override
    public String call() {
        log.info("call 메소드 실행");
        return "TestA";
    }
}
