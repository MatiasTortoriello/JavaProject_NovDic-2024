package com.coderhouse.clase_12.repository;

import com.coderhouse.clase_12.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
