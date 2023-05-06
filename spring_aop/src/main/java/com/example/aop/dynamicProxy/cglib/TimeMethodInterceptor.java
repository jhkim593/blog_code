package com.example.aop.dynamicProxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("TimeMethodInterceptor 실행");
        long startTime = System.currentTimeMillis();

        //타겟 객체 메소드 호출
        Object result = methodProxy.invoke(target, objects);

        long endTime = System.currentTimeMillis();

        log.info("TimeMethodInterceptor 종료");
        log.info("resultTime={}", endTime - startTime);
        return result;
    }
}
