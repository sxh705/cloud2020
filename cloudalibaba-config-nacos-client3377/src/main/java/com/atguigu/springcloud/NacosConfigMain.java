package com.atguigu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@SpringBootApplication
public class NacosConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain.class, args);
    }
}

// nacos自动刷新配置注解
@RestController
@RefreshScope
class a {
    @Value("${config.info}\t")
    private String configInfo;

    @RequestMapping
    public String b() {
        return configInfo + UUID.randomUUID().toString();
    }
}