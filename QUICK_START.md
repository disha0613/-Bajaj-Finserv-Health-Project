# 🚀 Quick Start Guide - Bajaj Finserv Health

## ⚡ Get Running in 3 Steps

### 1. Install Maven
```bash
# Run this file for Maven installation help
setup-maven.bat
```

### 2. Run the Application
```bash
# Option A: Direct run
mvn spring-boot:run

# Option B: Build and run JAR
mvn clean package
java -jar target/bajaj-health-1.0-SNAPSHOT.jar
```

### 3. Watch the Magic Happen! ✨

The application will automatically:
- 🔑 Generate webhook and access token
- 📝 Determine SQL question (REG12347 → Question 1)
- 📤 Submit final SQL query
- ✅ Complete the assignment

## 🔧 What You Need to Change

**⚠️ IMPORTANT**: Replace placeholder SQL queries in `WebhookService.java`:

```java
// Line ~120 in WebhookService.java
if (lastTwoDigitsInt % 2 == 1) {
    return "YOUR_ACTUAL_QUESTION_1_SQL;";  // ← Replace this!
} else {
    return "YOUR_ACTUAL_QUESTION_2_SQL;";  // ← Replace this!
}
```

## 📊 Expected Output

```
🚀 Starting Bajaj Finserv Health Assignment...
📋 Starting assignment execution...
🔑 Step 1: Generating webhook and access token...
✅ Webhook generated successfully!
📝 Step 2: Determining SQL question...
📊 Registration Number: REG12347
🔍 Last 2 digits: 47
💾 SQL Query: SELECT * FROM employees;
📤 Step 3: Submitting final SQL query...
🎉 Assignment completed successfully!
```

## 🆘 Need Help?

- **Maven issues**: Run `setup-maven.bat`
- **Full documentation**: Read `README.md`
- **Project summary**: Check `PROJECT_SUMMARY.md`

---

**🎯 Ready to go! Just install Maven and run `mvn spring-boot:run`**
