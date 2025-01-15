package com.coderhouse.clase_12.controller;

import com.coderhouse.clase_12.dto.AsignacionCategoriaCursoDTO;
import com.coderhouse.clase_12.model.Curso;
import com.coderhouse.clase_12.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        try {
            List<Curso> cursos = cursoService.getAllCursos();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        try {
            Curso curso = cursoService.getCursoById(id);
            return ResponseEntity.ok(curso);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        try {
            Curso createdCurso = cursoService.createCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCurso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        try {
            Curso updatedCurso = cursoService.updateCurso(id, cursoDetails);
            return ResponseEntity.ok(updatedCurso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id){
        try {
            cursoService.deleteCursoById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/asignar-categoria")
    public ResponseEntity<Curso> asignarCategoriaACurso(@RequestBody AsignacionCategoriaCursoDTO asignacionCategoriaCursoDTO){
        try {
            Curso cursoActualizado = cursoService.asignarCategoriaACurso(
                    asignacionCategoriaCursoDTO.getCursoId(),
                    asignacionCategoriaCursoDTO.getCategoriaId()
            );
            return ResponseEntity.ok(cursoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

