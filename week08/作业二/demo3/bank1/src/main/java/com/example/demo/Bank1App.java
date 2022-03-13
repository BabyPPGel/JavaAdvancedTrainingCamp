package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@ComponentScan({"com.congge","org.dromara.hmily"})
@EnableFeignClients(basePackages = {"com.congge.feign"})
public class Bank1App {

    public static void main(String[] args) {
        SpringApplication.run(Bank1App.class,args);
    }

}