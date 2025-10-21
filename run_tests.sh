#!/bin/bash
# Examples to test endpoints (Linux/mac)
echo "Criar tarefa..."
curl -s -X POST http://localhost:8080/api/tarefas -H "Content-Type: application/json" -d '{"nome":"Trabalho Back-end - Gabriella Pereira Barreiros - RU:4762792","dataEntrega":"2025-10-18","responsavel":"Gabriella Pereira Barreiros - RU:4762792"}' | jq
echo "\nListar tarefas..."
curl -s http://localhost:8080/api/tarefas | jq
