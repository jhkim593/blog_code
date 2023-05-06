package com.example.aop.service;

import com.example.aop.dto.UserDto;
import com.example.aop.aspect.Decode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserTestService {

    @Decode
    public UserDto createUser(UserDto userDto){
        log.info("user 생성 로직 실행 : {}",userDto.toString());
        return userDto;
    }

}
