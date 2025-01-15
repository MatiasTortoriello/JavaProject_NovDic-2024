package com.coderhouse.clase_10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    @Column(unique = true, nullable = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Curso> cursos = new ArrayList<>();


    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        return "Categoría{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
