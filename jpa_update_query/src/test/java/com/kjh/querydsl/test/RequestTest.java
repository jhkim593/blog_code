package com.kjh.querydsl.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RequestTest {
    @Autowired
    RequestService requestService;

    @Test
    public void selectTest(){
       requestService.find(1l);
    }
}
