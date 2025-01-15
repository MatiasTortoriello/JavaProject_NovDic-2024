package com.coderhouse.clase_11.repository;

import com.coderhouse.clase_11.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
