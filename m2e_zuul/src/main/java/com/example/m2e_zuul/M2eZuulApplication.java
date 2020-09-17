package com.example.m2e_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableEurekaClient
public class M2eZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eZuulApplication.class, args);
    }


    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
