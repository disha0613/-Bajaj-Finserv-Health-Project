package com.bajajfinservhealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/test")
    public String test() {
        return "✅ Spring Boot application is running!";
    }
    
    @GetMapping("/test-connectivity")
    public String testConnectivity() {
        try {
            String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return "✅ API Connectivity Test: " + response.getStatusCode() + " - " + response.getBody();
        } catch (Exception e) {
            return "❌ API Connectivity Test Failed: " + e.getMessage();
        }
    }
    
    @PostMapping("/test-webhook")
    public String testWebhook(@RequestBody String requestBody) {
        try {
            String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);
            return "✅ Webhook Test: " + response.getStatusCode() + " - " + response.getBody();
        } catch (Exception e) {
            return "❌ Webhook Test Failed: " + e.getMessage();
        }
    }
}
