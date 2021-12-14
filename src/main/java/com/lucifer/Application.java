package com.lucifer;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by lijc on 15/8/27.
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.lucifer")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
