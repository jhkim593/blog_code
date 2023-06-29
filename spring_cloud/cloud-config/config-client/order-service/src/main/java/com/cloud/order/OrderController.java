package com.cloud.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderController {

    @Value("${order.var1}")
    private String var1;

    @Value("${order.var2}")
    private String var2;

    @Value("${common.var}")
    private String commonVar1;

    @GetMapping("/test")
    public ResponseEntity test() {
        String response =
                "var1 : " + var1+ " , "+
                "var2 : " + var2 + " , " +
                "common.var : "+commonVar1;
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
