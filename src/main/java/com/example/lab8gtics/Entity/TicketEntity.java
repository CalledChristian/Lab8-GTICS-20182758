package com.example.lab8gtics.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "lahaces", catalog = "")
public class TicketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idTipoTicket")
    private int idTipoTicket;
    @Basic
    @Column(name = "idUsuario")
    private int idUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoTicket() {
        return idTipoTicket;
    }

    public void setIdTipoTicket(int idTipoTicket) {
        this.idTipoTicket = idTipoTicket;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return id == that.id && idTipoTicket == that.idTipoTicket && idUsuario == that.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTipoTicket, idUsuario);
    }
}
