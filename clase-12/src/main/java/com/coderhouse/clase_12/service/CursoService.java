package com.coderhouse.clase_12.service;

import com.coderhouse.clase_12.model.Categoria;
import com.coderhouse.clase_12.model.Curso;
import com.coderhouse.clase_12.repository.CategoriaRepository;
import com.coderhouse.clase_12.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id){
        return cursoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Curso no encontrado"));
    }

    @Transactional
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public Curso updateCurso(Long id, Curso cursoDetails) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        curso.setNombre(cursoDetails.getNombre());
        return cursoRepository.save(curso);
    }

    public void deleteCursoById(Long id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Curso no encontrado");
        }
    }

    @Transactional
    public Curso asignarCategoriaACurso(Long cursoId, Long categoriaId){
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        curso.setCategoria(categoria);
        return cursoRepository.save(curso);
    }
}
