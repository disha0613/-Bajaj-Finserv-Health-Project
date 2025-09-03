package com.bajajfinservhealth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BajajApp {

    public static void main(String[] args) {
        SpringApplication.run(BajajApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner commandLineRunner(WebhookService webhookService) {
        return args -> {
            System.out.println("🚀 Starting Bajaj Finserv Health Assignment...");
            webhookService.executeAssignment();
        };
    }
}
