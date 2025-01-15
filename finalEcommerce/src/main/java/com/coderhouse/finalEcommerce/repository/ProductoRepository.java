package com.coderhouse.finalEcommerce.repository;

import com.coderhouse.finalEcommerce.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
