package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${spring.application.name}\t")
    private String serverName;

    @RequestMapping("consul")
    public String consul() {
        return serverName + UUID.randomUUID();
    }
}
