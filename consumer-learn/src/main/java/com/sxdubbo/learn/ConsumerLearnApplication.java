package com.sxdubbo.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:consumers.xml"})
public class ConsumerLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerLearnApplication.class, args);
    }
}
