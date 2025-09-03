package com.bajajfinservhealth.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitQueryRequest {
    
    @JsonProperty("finalQuery")
    private String finalQuery;
    
    // Default constructor
    public SubmitQueryRequest() {}
    
    // Constructor with parameters
    public SubmitQueryRequest(String finalQuery) {
        this.finalQuery = finalQuery;
    }
    
    // Getters and Setters
    public String getFinalQuery() {
        return finalQuery;
    }
    
    public void setFinalQuery(String finalQuery) {
        this.finalQuery = finalQuery;
    }
    
    @Override
    public String toString() {
        return "SubmitQueryRequest{" +
                "finalQuery='" + finalQuery + '\'' +
                '}';
    }
}
