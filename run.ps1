# Bajaj Finserv Health - Direct Run (PowerShell)
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Bajaj Finserv Health - Direct Run" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "Checking Java version..." -ForegroundColor Yellow
java -version
Write-Host ""

Write-Host "Creating target directory..." -ForegroundColor Yellow
if (!(Test-Path "target")) { New-Item -ItemType Directory -Path "target" }
if (!(Test-Path "target\classes")) { New-Item -ItemType Directory -Path "target\classes" }

Write-Host "Compiling Java files..." -ForegroundColor Yellow
try {
    javac -cp "lib/*" -d target/classes src/main/java/com/bajajfinservhealth/*.java src/main/java/com/bajajfinservhealth/model/*.java
    Write-Host "✅ Compilation successful!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Note: This is a simplified run approach." -ForegroundColor Yellow
    Write-Host "For full functionality, please install Maven and use:" -ForegroundColor Yellow
    Write-Host "  mvn spring-boot:run" -ForegroundColor Cyan
} catch {
    Write-Host "❌ Compilation failed!" -ForegroundColor Red
    Write-Host ""
    Write-Host "This approach requires all dependencies to be downloaded manually." -ForegroundColor Yellow
    Write-Host "It's recommended to install Maven and use: mvn spring-boot:run" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "Running setup-maven.bat for Maven installation help..." -ForegroundColor Yellow
    & "setup-maven.bat"
}

Write-Host ""
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
