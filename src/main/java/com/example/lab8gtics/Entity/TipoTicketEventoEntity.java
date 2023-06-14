package com.example.lab8gtics.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_ticket_evento", schema = "lahaces", catalog = "")
public class TipoTicketEventoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "precio")
    private String precio;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "idEvento")
    private int idEvento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTicketEventoEntity that = (TipoTicketEventoEntity) o;
        return id == that.id && idEvento == that.idEvento && Objects.equals(precio, that.precio) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, precio, cantidad, idEvento);
    }
}
