# Tarefa API - Projeto para Trabalho

**Aluno:** Gabriella Pereira Barreiros  
**RU:** 4762792

## Descrição
API RESTful em Spring Boot para gerenciar tarefas (CRUD).

## Como usar (MySQL real)
1. Crie o banco de dados no MySQL:
```sql
CREATE DATABASE tarefasdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
2. Ajuste `src/main/resources/application.properties` com seu usuário/senha de MySQL.
3. Build e run:
```bash
mvn clean package
java -jar target/tarefa-api-0.0.1-SNAPSHOT.jar
```
A aplicação roda em `http://localhost:8080`.

## Endpoints
- POST `/api/tarefas` — criar tarefa (JSON)
- GET `/api/tarefas` — listar todas
- GET `/api/tarefas/{id}` — buscar por id
- PUT `/api/tarefas/{id}` — atualizar
- DELETE `/api/tarefas/{id}` — remover

## Exemplo de JSON (criar)
```json
{ "nome":"Trabalho Back-end - Gabriella Pereira Barreiros - RU:4762792", "dataEntrega":"2025-10-20", "responsavel":"Gabriella Pereira Barreiros - RU:4762792" }
```


