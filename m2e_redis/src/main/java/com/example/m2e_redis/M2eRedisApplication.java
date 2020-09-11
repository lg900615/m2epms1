package com.example.m2e_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.redis.utils"})
public class M2eRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eRedisApplication.class, args);
    }

}
