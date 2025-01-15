package com.coderhouse.finalEcommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Representa una venta realizada en el sistema de e-commerce.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    /**
     * Identificador único de la venta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente que realizó la venta.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /**
     * Detalles de los productos incluidos en la venta.
     */
    @OneToMany(mappedBy = "venta")
    private List<VentaDetalle> detalles;
}
