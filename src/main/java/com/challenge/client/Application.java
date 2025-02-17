package com.challenge.client;

import com.challenge.client.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        AppConfig.configureProfile();
        new SpringApplicationBuilder(Application.class).registerShutdownHook(true).run(args);
    }
}