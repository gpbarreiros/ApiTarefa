package com.example.tarefaapi.controller;

import com.example.tarefaapi.model.Tarefa;
import com.example.tarefaapi.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController(TarefaRepository repo){
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa){
        Tarefa saved = repo.save(tarefa);
        return ResponseEntity.created(URI.create("/api/tarefas/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Tarefa> listar(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id){
        Optional<Tarefa> t = repo.findById(id);
        return t.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        return repo.findById(id).map(existing -> {
            existing.setNome(tarefa.getNome());
            existing.setDataEntrega(tarefa.getDataEntrega());
            existing.setResponsavel(tarefa.getResponsavel());
            Tarefa updated = repo.save(existing);
            return ResponseEntity.ok(updated);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        return repo.findById(id).map(existing -> {
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
