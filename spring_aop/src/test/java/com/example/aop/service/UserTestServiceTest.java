package com.example.aop.service;

import com.example.aop.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class UserTestServiceTest {

    @Autowired
    private UserTestService userTestService;

    @Test
    public void createUser(){
        //given
        UserDto userDto = new UserDto();
        userDto.setUsername("username");
        String base64Password = Base64.getEncoder().encodeToString("password".getBytes());
        userDto.setPassword(base64Password);
        userDto.setEmail("test@test.com");

        //when
        UserDto result = userTestService.createUser(userDto);
        log.info("user 생성 완료 : {}",userDto.toString());

        //then
        assertThat(result.getPassword()).isEqualTo(base64Password);

    }
}