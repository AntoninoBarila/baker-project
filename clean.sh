#!/bin/bash
echo '🧹 Rimozione container e immagini Docker...'
docker-compose down
docker rmi -f baker-server baker-client microservice-1 microservice-2 microservice-3 || true
