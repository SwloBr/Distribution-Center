package com.swlo.distribuitioncenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DistribuitionCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistribuitionCenterApplication.class, args);
    }

}
