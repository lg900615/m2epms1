package com.example.m2e_user_allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.example.m2e_user_allocation.*","com.util"})
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
//@EnableFeignClients
public class M2eUserAllocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2eUserAllocationApplication.class, args);
    }

}
