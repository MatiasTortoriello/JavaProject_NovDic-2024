package com.coderhouse.finalEcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una categoría de productos en el sistema de e-commerce.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {
    /**
     * Identificador único de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría. Debe ser único y no puede ser nulo.
     */
    @Column(unique = true, nullable = false)
    private String nombre;

    /**
     * Lista de productos que pertenecen a esta categoría.
     */
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

}
