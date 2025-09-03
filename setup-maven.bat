@echo off
echo ========================================
echo Bajaj Finserv Health - Maven Setup
echo ========================================
echo.

echo Checking if Maven is already installed...
mvn -version >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Maven is already installed!
    echo.
    echo You can now run:
    echo   mvn spring-boot:run
    echo   mvn clean package
    goto :end
)

echo ❌ Maven not found. Installing Maven...
echo.

echo Step 1: Downloading Maven...
echo Please download Maven from: https://maven.apache.org/download.cgi
echo Choose: apache-maven-3.9.6-bin.zip
echo.

echo Step 2: Extract to C:\Program Files\Apache\maven
echo.

echo Step 3: Add to PATH environment variable:
echo Add: C:\Program Files\Apache\maven\bin
echo.

echo Step 4: Restart your terminal/PowerShell
echo.

echo Alternative: Use the provided run.bat file to run without Maven
echo.

:end
pause
