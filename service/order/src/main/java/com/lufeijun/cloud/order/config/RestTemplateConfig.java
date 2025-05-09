package com.lufeijun.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // 负载均衡，加上负载均衡后注解后，IndexController中的 toUser1、toUser2 就没法用了，不知道为啥
    // 应该加注解后，就自动走负载均衡逻辑了，
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean(name = "RestTemplateLoadBalanced")
    @LoadBalanced
    public RestTemplate restTemplateLoadBalanced() {
        return new RestTemplate();
    }
}
