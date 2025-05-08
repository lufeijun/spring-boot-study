package com.lufeijun.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean(name = "RestTemplateLoadBalanced")
    public RestTemplate restTemplateLoadBalanced() {
        return new RestTemplate();
    }
}
