package com.coderhouse.clase_10.controller;

import com.coderhouse.clase_10.model.Categoria;
import com.coderhouse.clase_10.model.Curso;
import com.coderhouse.clase_10.repository.CategoriaRepository;
import com.coderhouse.clase_10.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        if(categoriaRepository.existsById(id)){
            Categoria categoria = categoriaRepository.findById(id).get();
            return ResponseEntity.ok(categoria);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
