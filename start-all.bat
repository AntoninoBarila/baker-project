@echo off
echo 🚀 Starting all modules using spring-boot:run
start cmd /k "cd microservice-1 && mvn spring-boot:run"
start cmd /k "cd microservice-2 && mvn spring-boot:run"
start cmd /k "cd microservice-3 && mvn spring-boot:run"
start cmd /k "cd baker-server && mvn spring-boot:run"
start cmd /k "cd baker-client && mvn spring-boot:run"
