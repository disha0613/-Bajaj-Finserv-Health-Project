@echo off
echo ========================================
echo Bajaj Finserv Health - Direct Run
echo ========================================
echo.

echo Checking Java version...
java -version
echo.

echo Creating target directory...
if not exist "target" mkdir target
if not exist "target\classes" mkdir target\classes

echo Compiling Java files...
javac -cp "lib/*" -d target/classes src/main/java/com/bajajfinservhealth/*.java src/main/java/com/bajajfinservhealth/model/*.java
if %errorlevel% neq 0 (
    echo ❌ Compilation failed! 
    echo.
    echo This approach requires all dependencies to be downloaded manually.
    echo It's recommended to install Maven and use: mvn spring-boot:run
    echo.
    echo Running setup-maven.bat for Maven installation help...
    call setup-maven.bat
    goto :end
)

echo ✅ Compilation successful!
echo.
echo Note: This is a simplified run approach.
echo For full functionality, please install Maven and use:
echo   mvn spring-boot:run
echo.

:end
pause
