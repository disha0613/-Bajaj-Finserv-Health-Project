# Bajaj Finserv Health - Qualifier 1 | JAVA

A Spring Boot application that automatically executes the Bajaj Finserv Health assignment on startup.

## 🎯 Project Overview

This application implements the complete flow for the Bajaj Finserv Health assignment:

1. **Generate Webhook**: Sends initial request to get webhook URL and access token
2. **Determine SQL Question**: Based on registration number (odd/even logic)
3. **Submit Final Query**: Posts the SQL query with proper authorization

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/bajajfinservhealth/
│   │   ├── BajajApp.java              # Main Spring Boot Application
│   │   ├── WebhookService.java        # Core business logic service
│   │   └── model/                     # Data models
│   │       ├── GenerateWebhookRequest.java
│   │       ├── GenerateWebhookResponse.java
│   │       └── SubmitQueryRequest.java
│   └── resources/
│       └── application.properties      # Application configuration
├── pom.xml                            # Maven dependencies
└── README.md                          # This file
```

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

#### Option 1: Maven Spring Boot Run
```bash
mvn spring-boot:run
```

#### Option 2: Build and Run JAR
```bash
# Build the project
mvn clean package

# Run the generated JAR
java -jar target/bajaj-health-1.0-SNAPSHOT.jar
```

## 📋 What Happens on Startup

1. **Application Initialization**: Spring Boot starts up
2. **CommandLineRunner Execution**: Automatically triggers the assignment flow
3. **Webhook Generation**: POST request to generate webhook and access token
4. **SQL Question Determination**: Logic based on registration number
5. **Final Submission**: POST request with SQL query and authorization

## 🔧 Configuration

### Application Properties
- **Port**: 8080 (configurable in `application.properties`)
- **Logging**: DEBUG level for detailed execution logs
- **Jackson**: Configured for JSON serialization/deserialization

### API Endpoints
- **Generate Webhook**: `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Submit Query**: `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`

## 📊 SQL Question Logic

The application determines which SQL question to answer based on the last 2 digits of the registration number:

- **REG12347** → Last 2 digits: **47** (odd) → **Question 1**
- **Even numbers** → **Question 2**

**Current Placeholder Queries:**
- Question 1: `SELECT * FROM employees;`
- Question 2: `SELECT * FROM departments;`

> **Note**: Replace these placeholder queries with the actual SQL queries from the Google Drive link once you have access to the problem statement.

## 🧪 Testing

The application runs automatically on startup. You can verify it's working by:

1. Checking the console logs for execution flow
2. Monitoring HTTP requests/responses
3. Verifying successful submission

## 📦 Dependencies

- **Spring Boot Starter Web**: Core web functionality
- **Jackson Databind**: JSON processing
- **Spring Boot Starter Test**: Testing support

## 🔍 Troubleshooting

### Common Issues

1. **Port Already in Use**
   ```bash
   # Change port in application.properties
   server.port=8081
   ```

2. **Java Version Mismatch**
   ```bash
   # Ensure Java 17+ is installed
   java -version
   ```

3. **Maven Issues**
   ```bash
   # Clean and rebuild
   mvn clean install
   ```

### Logs
The application provides detailed logging for debugging:
- Request/response details
- Execution flow
- Error messages with stack traces

## 📝 Customization

### Changing Registration Details
Edit `WebhookService.java`:
```java
GenerateWebhookRequest request = new GenerateWebhookRequest(
    "Your Name",           // Change name
    "YOUR_REG_NO",        // Change registration number
    "your@email.com"      // Change email
);
```

### Updating SQL Queries
Edit `WebhookService.java` in the `determineSqlQuestion` method:
```java
if (lastTwoDigitsInt % 2 == 1) {
    return "YOUR_ACTUAL_QUESTION_1_SQL;";
} else {
    return "YOUR_ACTUAL_QUESTION_2_SQL;";
}
```

## 🎉 Success Indicators

When the application runs successfully, you should see:
- ✅ Webhook generated successfully
- ✅ SQL question determined
- ✅ Final query submitted
- 🎉 Assignment completed successfully

## 📞 Support

For any issues or questions:
1. Check the console logs for detailed error information
2. Verify your internet connection for API calls
3. Ensure the API endpoints are accessible

---

**Happy Coding! 🚀**
