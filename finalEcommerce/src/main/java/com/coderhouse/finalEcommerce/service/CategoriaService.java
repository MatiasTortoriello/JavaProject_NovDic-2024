package com.coderhouse.finalEcommerce.service;

import com.coderhouse.finalEcommerce.entity.Categoria;
import com.coderhouse.finalEcommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra categoría con ID: " + id));
    }
}
