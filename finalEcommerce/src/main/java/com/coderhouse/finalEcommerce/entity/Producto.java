package com.coderhouse.finalEcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto disponible en el sistema de e-commerce.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private long id;

    private String titulo;

    private String descripcion;

    private double precio;

    private int stock;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "producto_cliente",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
        )

    @JsonIgnore
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Categoría a la que pertenece el producto.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

}
