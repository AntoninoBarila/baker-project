#!/bin/bash

echo "🔄 Costruzione progetto..."
mvn clean install -DskipTests

echo "🚀 Avvio dei moduli Spring Boot (ordine corretto)..."

open -a Terminal "$(pwd)/microservice-1/start-micro1.sh"
open -a Terminal "$(pwd)/microservice-2/start-micro2.sh"
open -a Terminal "$(pwd)/microservice-3/start-micro3.sh"
open -a Terminal "$(pwd)/baker-server/start-server.sh"
open -a Terminal "$(pwd)/baker-client/start-client.sh"
