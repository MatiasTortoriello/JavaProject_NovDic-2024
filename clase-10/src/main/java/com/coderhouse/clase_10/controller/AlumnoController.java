package com.coderhouse.clase_10.controller;

import com.coderhouse.clase_10.model.Alumno;
import com.coderhouse.clase_10.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        if(alumnoRepository.existsById(id)){
            Alumno alumno = alumnoRepository.findById(id).get();
            return ResponseEntity.ok(alumno);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }


}
