package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
//@Component
public class Aspect4 {

    @Pointcut("execution(* com.example.aop.service..*(..))")
    public void all(){ }

    @Aspect
//    @Component
    @Order(1)
    static class LogAspect{
        @Around("com.example.aop.aspect.Aspect4.all()")
        public Object doLog(ProceedingJoinPoint joinPoint) {
            log.info("start :{}", joinPoint.getSignature());
            Object result = null;
            try {
                result = joinPoint.proceed();
            } catch (Throwable throwable) {
            }
            log.info("end : {}", joinPoint.getSignature());
            return result;
        }
    }

    @Aspect
//    @Component
    @Order(2)
    static class TimeAspect{
        @Around("com.example.aop.aspect.Aspect4.all()")
        public Object timeCheck(ProceedingJoinPoint joinPoint){
            log.info("start time check");
            long startTime = System.currentTimeMillis();

            //타겟 객체 메소드 호출
            Object result = null;
            try {
                result = joinPoint.proceed();
            } catch (Throwable throwable) {
            }

            long endTime = System.currentTimeMillis();

            log.info("end time check");
            log.info("resultTime={}", endTime - startTime);
            return result;
        }
    }

}
