package com.sala1.sala1.controller;

import com.sala1.sala1.entity.Reserva;
import com.sala1.sala1.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> createReserva(@RequestBody Reserva reserva) {
        try {
            // Lógica para criar reserva
            Reserva novaReserva = reservaService.createReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar reserva: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Reserva reserva = reservaService.getReservaById(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva updatedReserva = reservaService.updateReserva(id, reserva);
        if (updatedReserva != null) {
            return ResponseEntity.ok(updatedReserva);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReserva(@PathVariable Long id) {
        if (reservaService.deleteReserva(id)) {
            return ResponseEntity.ok("Reserva deletada com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada.");
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reserva>> getReservasPorUsuario(@PathVariable Long usuarioId) {
        List<Reserva> reservas = reservaService.getReservasByUsuarioId(usuarioId);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<Reserva>> getReservasPorSala(@PathVariable Long salaId) {
        List<Reserva> reservas = reservaService.getReservasBySalaId(salaId);
        return ResponseEntity.ok(reservas);
    }
}
