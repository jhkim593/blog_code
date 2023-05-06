package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
//@Component
public class Aspect3 {

    @Pointcut("execution(* com.example.aop.service..*(..))")
    public void all(){ }

    @Pointcut("execution(* *..*Servie.*(..))")
    public void allService(){ }


    @Around("all() && allService()")
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
