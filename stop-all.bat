@echo off
echo 🛑 Stopping all running Spring Boot modules...
for /f "tokens=2" %%a in ('tasklist ^| findstr /i "java.exe"') do (
  taskkill /PID %%a /F
)
