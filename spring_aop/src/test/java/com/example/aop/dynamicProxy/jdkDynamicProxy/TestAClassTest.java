package com.example.aop.dynamicProxy.jdkDynamicProxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
class TestAClassTest {

    @Test
    void dynamicA() {
        TestAInterface target = new TestImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        TestAInterface proxy = (TestAInterface)
                Proxy.newProxyInstance(TestAInterface.class.getClassLoader(), new Class[]
                        {TestAInterface.class}, handler);
        String result = proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        log.info("result = {}", result);
    }
}