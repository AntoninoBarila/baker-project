#!/bin/bash
set -e

echo "📦 Build dei moduli Maven..."
mvn clean package -DskipTests

echo "🐳 Build delle immagini Docker..."
docker build -t baker-server ./baker-server
docker build -t baker-client ./baker-client
docker build -t microservice-1 ./microservice-1
docker build -t microservice-2 ./microservice-2
docker build -t microservice-3 ./microservice-3

echo "✅ Tutto buildato con successo."
