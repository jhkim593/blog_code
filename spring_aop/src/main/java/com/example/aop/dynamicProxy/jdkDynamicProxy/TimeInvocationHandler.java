package com.example.aop.dynamicProxy.jdkDynamicProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
    public final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeInvocationHandler 실행");
        long startTime = System.currentTimeMillis();

        //타겟 메소드 실행
        Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();

        log.info("TimeInvocationHandler 종료");
        log.info("resultTime={}", endTime - startTime);
        return result;

    }
}
