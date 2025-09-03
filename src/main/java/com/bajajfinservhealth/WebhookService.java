package com.bajajfinservhealth;

import com.bajajfinservhealth.model.GenerateWebhookRequest;
import com.bajajfinservhealth.model.GenerateWebhookResponse;
import com.bajajfinservhealth.model.SubmitQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {
    
    private static final String GENERATE_WEBHOOK_URL = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
    private static final String SUBMIT_QUERY_URL = "https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA";
    
    @Autowired
    private RestTemplate restTemplate;
    
    public void executeAssignment() {
        try {
            System.out.println("📋 Starting assignment execution...");
            
            // Step 1: Generate webhook and get access token
            System.out.println("🔑 Step 1: Generating webhook and access token...");
            GenerateWebhookResponse webhookResponse = generateWebhook();
            
            if (webhookResponse == null || webhookResponse.getAccessToken() == null) {
                System.err.println("❌ Failed to generate webhook or get access token");
                return;
            }
            
            System.out.println("✅ Webhook generated successfully!");
            System.out.println("🔗 Webhook URL: " + webhookResponse.getWebhook());
            System.out.println("🔑 Access Token: " + webhookResponse.getAccessToken().substring(0, Math.min(webhookResponse.getAccessToken().length(), 20)) + "...");
            
            // Step 2: Determine SQL question based on regNo
            System.out.println("📝 Step 2: Determining SQL question...");
            String regNo = "REG12347"; // From the assignment
            String sqlQuery = determineSqlQuestion(regNo);
            System.out.println("📊 Registration Number: " + regNo);
            System.out.println("🔍 Last 2 digits: " + regNo.substring(regNo.length() - 2));
            System.out.println("💾 SQL Query: " + sqlQuery);
            
            // Step 3: Submit the final SQL query
            System.out.println("📤 Step 3: Submitting final SQL query...");
            boolean submissionSuccess = submitFinalQuery(webhookResponse.getAccessToken(), sqlQuery);
            
            if (submissionSuccess) {
                System.out.println("🎉 Assignment completed successfully!");
            } else {
                System.err.println("❌ Assignment submission failed!");
            }
            
        } catch (Exception e) {
            System.err.println("💥 Error during assignment execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private GenerateWebhookResponse generateWebhook() {
        try {
            GenerateWebhookRequest request = new GenerateWebhookRequest(
                "John Doe",
                "REG12347", 
                "john@example.com"
            );
            
            System.out.println("📤 Sending request to: " + GENERATE_WEBHOOK_URL);
            System.out.println("📋 Request body: " + request);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            HttpEntity<GenerateWebhookRequest> entity = new HttpEntity<>(request, headers);
            
            ResponseEntity<GenerateWebhookResponse> response = restTemplate.exchange(
                GENERATE_WEBHOOK_URL,
                HttpMethod.POST,
                entity,
                GenerateWebhookResponse.class
            );
            
            System.out.println("📥 Response received with status: " + response.getStatusCode());
            System.out.println("📋 Response body: " + response.getBody());
            
            return response.getBody();
            
        } catch (Exception e) {
            System.err.println("❌ Error generating webhook: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    private String determineSqlQuestion(String regNo) {
        // Extract last 2 digits from regNo
        String lastTwoDigits = regNo.substring(regNo.length() - 2);
        int lastTwoDigitsInt = Integer.parseInt(lastTwoDigits);
        
        System.out.println("🔢 Last 2 digits: " + lastTwoDigits + " (Value: " + lastTwoDigitsInt + ")");
        
        // Determine if odd or even
        if (lastTwoDigitsInt % 2 == 1) {
            // Odd - Question 1
            System.out.println("📚 Question 1 selected (odd number)");
            return "SELECT * FROM employees;"; // Placeholder for Question 1
        } else {
            // Even - Question 2  
            System.out.println("📚 Question 2 selected (even number)");
            return "SELECT * FROM departments;"; // Placeholder for Question 2
        }
    }
    
    private boolean submitFinalQuery(String accessToken, String sqlQuery) {
        try {
            SubmitQueryRequest request = new SubmitQueryRequest(sqlQuery);
            
            System.out.println("📤 Submitting to: " + SUBMIT_QUERY_URL);
            System.out.println("📋 Request body: " + request);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", accessToken);
            
            System.out.println("🔑 Authorization header: " + accessToken.substring(0, Math.min(accessToken.length(), 20)) + "...");
            
            HttpEntity<SubmitQueryRequest> entity = new HttpEntity<>(request, headers);
            
            ResponseEntity<String> response = restTemplate.exchange(
                SUBMIT_QUERY_URL,
                HttpMethod.POST,
                entity,
                String.class
            );
            
            System.out.println("📥 Submission response status: " + response.getStatusCode());
            System.out.println("📋 Submission response body: " + response.getBody());
            
            return response.getStatusCode().is2xxSuccessful();
            
        } catch (Exception e) {
            System.err.println("❌ Error submitting final query: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
