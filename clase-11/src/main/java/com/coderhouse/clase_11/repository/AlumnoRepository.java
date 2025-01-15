package com.coderhouse.clase_11.repository;

import com.coderhouse.clase_11.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
