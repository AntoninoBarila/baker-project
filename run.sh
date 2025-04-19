#!/bin/bash
echo "🚀 Avvio dei microservizi Baker..."

# Porta ogni microservizio su un terminale diverso (background)
./mvnw -pl baker-server spring-boot:run &
sleep 5
./mvnw -pl microservice-1 spring-boot:run &
./mvnw -pl microservice-2 spring-boot:run &
./mvnw -pl microservice-3 spring-boot:run &
sleep 5
./mvnw -pl baker-client spring-boot:run &
wait
