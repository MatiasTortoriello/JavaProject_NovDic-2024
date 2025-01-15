package com.coderhouse.finalEcommerce.repository;

import com.coderhouse.finalEcommerce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
