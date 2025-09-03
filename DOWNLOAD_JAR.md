# 📦 Download Compiled JAR File

## 🚀 Quick Download

### Option 1: GitHub Actions Artifacts (Recommended)
1. Go to [Actions tab](https://github.com/disha0613/-Bajaj-Finserv-Health-Project/actions)
2. Click on the latest successful workflow run
3. Scroll down to "Artifacts"
4. Download `bajaj-health-jar.zip`
5. Extract the ZIP file to get `bajaj-health-1.0-SNAPSHOT.jar`

### Option 2: GitHub Releases
1. Go to [Releases tab](https://github.com/disha0613/-Bajaj-Finserv-Health-Project/releases)
2. Download the latest release JAR file
3. The JAR will be named `bajaj-health.jar`

### Option 3: Direct Build
If you want to build it yourself:
```bash
git clone https://github.com/disha0613/-Bajaj-Finserv-Health-Project.git
cd -Bajaj-Finserv-Health-Project
mvn clean package
# JAR will be in target/bajaj-health-1.0-SNAPSHOT.jar
```

## 🎯 How to Run the JAR

### Prerequisites
- Java 17 or higher installed
- Internet connection (for API calls)

### Execute the JAR
```bash
java -jar bajaj-health-1.0-SNAPSHOT.jar
```

## 📋 What Happens When You Run the JAR

The application will automatically:
1. 🔑 Generate webhook and access token
2. 📝 Determine SQL question (REG12347 → Question 1)
3. 📤 Submit final SQL query
4. ✅ Complete the assignment

## 🔧 Expected Output

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

## 📊 Current SQL Queries

**⚠️ IMPORTANT**: These are placeholder queries. Replace them with actual SQL from the Google Drive link!

- **Question 1** (Odd numbers): `SELECT * FROM employees;`
- **Question 2** (Even numbers): `SELECT * FROM departments;`

## 🆘 Troubleshooting

- **Port conflicts**: Change port in `application.properties` or use `--server.port=8081`
- **Java version**: Ensure Java 17+ is installed (`java -version`)
- **API errors**: Check internet connection and API endpoint accessibility

---

**🎯 Ready to run! Download the JAR and execute with `java -jar bajaj-health-1.0-SNAPSHOT.jar`**
