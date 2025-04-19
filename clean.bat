@echo off
echo 🧹 Cleaning up Docker containers and images...
docker-compose down
docker rmi -f baker-server baker-client microservice-1 microservice-2 microservice-3
