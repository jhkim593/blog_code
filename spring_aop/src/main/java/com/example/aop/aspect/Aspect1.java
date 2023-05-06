package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
//@Component
public class Aspect1 {

    @Around("execution(* com.example.aop.service..*(..))")
    public Object timeCheck(ProceedingJoinPoint joinPoint){
        log.info("start");
        long startTime = System.currentTimeMillis();

        //타겟 객체 메소드 호출
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
        }

        long endTime = System.currentTimeMillis();

        log.info("end");
        log.info("resultTime={}", endTime - startTime);
        return result;
    }
}
