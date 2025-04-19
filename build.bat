@echo off
echo 📦 Building Maven project...
call mvn clean package -DskipTests
echo 🐳 Building Docker images...
docker build -t baker-server baker-server
docker build -t baker-client baker-client
docker build -t microservice-1 microservice-1
docker build -t microservice-2 microservice-2
docker build -t microservice-3 microservice-3
echo ✅ Build completed.
