package com.example.m2e_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class M2eServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eServerApplication.class, args);
    }

}
