package com.example.m2e_user_allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M2eUserAllocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eUserAllocationApplication.class, args);
    }

}
