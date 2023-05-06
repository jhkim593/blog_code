package com.example.aop.aspect;

import com.example.aop.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Slf4j
@Component
public class DecodeAspect {

    @Pointcut("@annotation(com.example.aop.aspect.Decode)")
    private void deCodePoint() {}

    @Before("deCodePoint()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {

        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof UserDto)  {
                //클래스 캐스팅
                UserDto userDto = UserDto.class.cast(arg);
                String base64Password = userDto.getPassword();
                //복호화
                String password = new String(Base64.getDecoder().decode(base64Password), "UTF-8");
                userDto.setPassword(password);
            }
        }
    }

    //리턴할때는 암호화 해서 리턴
    @AfterReturning(value = "deCodePoint()", returning = "userDto")
    public void afterReturn(JoinPoint joinPoint, UserDto userDto) {

        String password = userDto.getPassword();
        //암호화
        String base64Password = Base64.getEncoder().encodeToString(password.getBytes());
        userDto.setPassword(base64Password);

    }
}