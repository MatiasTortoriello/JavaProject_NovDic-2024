package com.coderhouse.clase_11.controller;

import com.coderhouse.clase_11.model.Alumno;
import com.coderhouse.clase_11.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        try {
            List<Alumno> alumnos = alumnoService.getAllAlumnos();
            return ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        try {
            Alumno alumno = alumnoService.findById(id);
            return ResponseEntity.ok(alumno);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        try {
            Alumno alumnoCreado = alumnoService.saveAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumnoById(@PathVariable Long id, @RequestBody Alumno alumnoModificado){
        try {
            Alumno updateAlumno = alumnoService.updateAlumnoById(id, alumnoModificado);
            return ResponseEntity.ok(updateAlumno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); //404
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumnoById(@PathVariable Long id){
        try {
            alumnoService.deleteAlumnoById(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); //404
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
