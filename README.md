# Baker Project – Microservizi + Akka + Spring Boot

## ✅ Descrizione
Questo progetto implementa una architettura a microservizi orchestrata con Baker 4.1.0 (Akka + JVM), integrata con Spring Boot.  
Comprende:
- `baker-server`: ospita e registra la recipe
- `baker-client`: invia eventi per innescare la recipe
- `shared`: contiene gli eventi condivisi
- `microservice-1`, `2`, `3`: contengono le interaction della recipe

---

## 🏁 Avvio con Maven (Mac/Linux)
```bash
chmod +x run.sh
./run.sh
```

## 🐳 Avvio con Docker Compose
```bash
docker compose build
docker compose up
```

---

## 🎯 Trigger della Recipe
Puoi inviare un evento `OrderReceivedEvent` per iniziare la recipe via:

### 🟢 Postman
Importa il file:
```
baker-client.postman_collection.json
```

Esegui la request:
```
POST http://localhost:8085/baker/trigger
{
  "orderId": "12345",
  "customerName": "Mario Rossi"
}
```

---

## 🔧 Build manuale
```bash
./mvnw clean install
```

---

## 📦 Struttura del progetto
- `baker-server`: espone la REST API `/baker/trigger`, registra recipe e interazioni
- `baker-client`: UI/REST che invia eventi a `baker-server`
- `shared`: modelli evento comuni
- `microservice-1`, `2`, `3`: contengono implementazioni delle `Interaction`

---

## 📁 Dockerfile + docker-compose
Ogni modulo contiene un `Dockerfile`, già integrato nel `docker-compose.yml`.

