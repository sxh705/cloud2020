package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }
}

@RestController
@Slf4j
class PaymentController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String SERVER_URL;

    @GetMapping("/echo/{str}")
    public String paymentInfo(@PathVariable String str) {
        log.info("id: {}", str);
        String url = SERVER_URL + "/echo/" + str;
        log.info("url: {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}

@Configuration
@Slf4j
class RestConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        log.info("restTemplate");
        return new RestTemplate();
    }
}

