package com.sala1.sala1.service;

import com.sala1.sala1.entity.Sala;
import com.sala1.sala1.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    public List<Sala> findAll() {
        return repository.findAll(); // Retorna todas as salas
    }

    public Sala saveSala(Sala sala) {
        return repository.save(sala); // Salva a sala e retorna a sala salva
    }

    public Optional<Sala> findById(Long id) {
        return repository.findById(id); // Retorna um Optional da sala encontrada
    }

    public Sala editSala(Sala sala, Long id) {
        Optional<Sala> salaDbOptional = this.findById(id);
        if (salaDbOptional.isPresent()) {
            Sala salaDb = salaDbOptional.get(); // Obtém a sala existente
            salaDb.setNome(sala.getNome() != null ? sala.getNome() : salaDb.getNome());
            salaDb.setDepartamento(sala.getDepartamento() != null ? sala.getDepartamento() : salaDb.getDepartamento());
            salaDb.setDescricao(sala.getDescricao() != null ? sala.getDescricao() : salaDb.getDescricao());
            salaDb.setAtivo(sala.getAtivo() != null ? sala.getAtivo() : salaDb.getAtivo());
            return repository.save(salaDb);
        }
        return null; // ou lance uma exceção personalizada
    }

    public void deleteSala(Long id) {
        repository.deleteById(id); // Exclui a sala pelo ID
    }
}
