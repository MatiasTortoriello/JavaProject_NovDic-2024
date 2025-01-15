package com.coderhouse.clase_10.controller;

import com.coderhouse.clase_10.model.Alumno;
import com.coderhouse.clase_10.model.Curso;
import com.coderhouse.clase_10.repository.AlumnoRepository;
import com.coderhouse.clase_10.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        if(cursoRepository.existsById(id)){
            Curso curso = cursoRepository.findById(id).get();
            return ResponseEntity.ok(curso);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

}

