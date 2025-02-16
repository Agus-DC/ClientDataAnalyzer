package com.challenge.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        AppConfig.configureProfile();
        SpringApplication.run(Application.class, args);
    }
}