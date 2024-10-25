package com.sala1.sala1.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "data_reserva")
    private Date dateReserva;

    @Column(name = "data_pedido")
    private Date dataPedido;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Construtores, Getters e Setters
    public Reserva() {
    }

    public Reserva(Long id, Date dateReserva, Date dataPedido, Boolean status, Sala sala, Usuario usuario) {
        this.id = id;
        this.dateReserva = dateReserva;
        this.dataPedido = dataPedido;
        this.status = status;
        this.sala = sala;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReserva() {
        return dateReserva;
    }

    public void setDateReserva(Date dateReserva) {
        this.dateReserva = dateReserva;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
