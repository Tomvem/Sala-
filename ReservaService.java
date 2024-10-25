package com.sala1.sala1.service;

import com.sala1.sala1.entity.Reserva;
import com.sala1.sala1.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva updateReserva(Long id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setId(id);
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public boolean deleteReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Reserva> getReservasByUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    public List<Reserva> getReservasBySalaId(Long salaId) {
        return reservaRepository.findBySalaId(salaId);
    }

    public boolean usuarioTemReservaAtiva(Long usuarioId) {
        // Implementar lógica para verificar se o usuário tem reserva ativa
        return !reservaRepository.findByUsuarioId(usuarioId).isEmpty();
    }

    public boolean salaJaReservada(Long salaId, Date dateReserva) {
        // Implementar lógica para verificar se a sala já está reservada
        return !reservaRepository.findBySalaId(salaId).isEmpty();
    }
}
