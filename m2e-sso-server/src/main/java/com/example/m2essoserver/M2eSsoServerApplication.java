package com.example.m2essoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.example.m2essoserver.*"})
public class M2eSsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(M2eSsoServerApplication.class, args);
    }

}
