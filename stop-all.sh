#!/bin/bash
echo '🛑 Terminazione di tutti i processi Spring Boot...'

PIDS=$(ps aux | grep '[m]vn spring-boot:run' | awk '{print $2}')
if [ -z "$PIDS" ]; then
  echo 'Nessun processo spring-boot:run trovato.'
else
  echo "Terminazione PID: $PIDS"
  kill -9 $PIDS
fi
