package com.sala1.sala1.repository;

import com.sala1.sala1.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    // Você pode adicionar métodos personalizados, se necessário
}
