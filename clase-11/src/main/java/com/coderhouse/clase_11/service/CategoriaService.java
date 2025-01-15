package com.coderhouse.clase_11.service;

import com.coderhouse.clase_11.model.Categoria;
import com.coderhouse.clase_11.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
    }

    public boolean existCategoriaById(Long id){
        return categoriaRepository.existsById(id);
    }

    @Transactional
    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria updateCategoria(long id, Categoria categoriaDetails){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada"));
        categoria.setNombre(categoriaDetails.getNombre());
        return categoriaRepository.save(categoria);
    }

    public void deteleCategoriaById(Long id){
        categoriaRepository.deleteById(id);
    }
}
