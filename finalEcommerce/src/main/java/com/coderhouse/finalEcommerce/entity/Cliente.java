package com.coderhouse.finalEcommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un cliente en el sistema de e-commerce.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    @Schema(description = "ID del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long Id;

    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "Marcelo")
    private String nombre;

    @Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "Carabajal")
    private String apellido;

    @Schema(description = "Edad del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "34")
    private int edad;

    @Column(unique = true, nullable = false)
    @Schema(description = "Email del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "example@example.com")
    private String email;

    @Column(unique = true, nullable = false)
    @Schema(description = "DNI del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "30111222")
    private int dni;

    @Column(name = "num_cliente")
    @Schema(description = "Numero de cliente", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private String numCliente;

    @ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
    private List<Producto> productos = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    @Schema(description = "Fecha de creación del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "2025-01-13T10:21:27.402135")
    private LocalDateTime createdAt;
}
