package com.sala1.sala1.controller;

import com.sala1.sala1.entity.Sala;
import com.sala1.sala1.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/salas")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public List<Sala> getSalas() {
        return service.findAll(); // Retorna todas as salas
    }

    @PostMapping
    public ResponseEntity<Sala> saveSala(@RequestBody Sala sala) {
        Sala salaSalva = service.saveSala(sala);
        return ResponseEntity.status(201).body(salaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> findById(@PathVariable Long id) {
        Optional<Sala> sala = service.findById(id);
        return sala.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> editSala(@PathVariable Long id, @RequestBody Sala sala) {
        Sala salaEditada = service.editSala(sala, id);
        return salaEditada != null ? ResponseEntity.ok(salaEditada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        service.deleteSala(id);
        return ResponseEntity.noContent().build(); //
    }
}
