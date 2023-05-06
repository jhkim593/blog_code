package com.example.aop.dynamicProxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
class TestServiceAspectTest {

    @Test
    void cglib() {
        TestService target = new TestService();
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(TestService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        //프록시 생성
        TestService proxy = (TestService)enhancer.create();

        //프록시 call 호출
        proxy.call();

        log.info("proxyClass={}", proxy.getClass());
        log.info("targetClass={}", target.getClass());
    }

}