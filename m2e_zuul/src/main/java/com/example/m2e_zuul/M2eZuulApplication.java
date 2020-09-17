package com.example.m2e_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class M2eZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eZuulApplication.class, args);
    }

}
