package com.coderhouse.clase_10.repository;

import com.coderhouse.clase_10.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
