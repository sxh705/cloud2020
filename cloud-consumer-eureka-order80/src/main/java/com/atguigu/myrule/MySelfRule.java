package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MySelfRule {
    // ribbon配置不应该被springbootApplication扫描到,否则会自动启用,起不到自动配置作用
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
