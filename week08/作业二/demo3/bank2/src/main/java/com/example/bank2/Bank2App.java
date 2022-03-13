package com.example.bank2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@ComponentScan({"com.congge","org.dromara.hmily"})
public class Bank2App {

    public static void main(String[] args) {
        SpringApplication.run(Bank2App.class,args);
    }

}