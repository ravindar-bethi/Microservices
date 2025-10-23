package com.dell.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="order.service")
public class OrderServiceConfig {
    private String url;
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
