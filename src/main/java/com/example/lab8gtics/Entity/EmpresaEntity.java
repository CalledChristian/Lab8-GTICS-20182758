package com.example.lab8gtics.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "lahaces", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "ruc")
    private String ruc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(ruc, that.ruc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ruc);
    }
}
