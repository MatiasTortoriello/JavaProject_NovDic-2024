package com.coderhouse.clase_09.dao;

import com.coderhouse.clase_09.models.Alumno;
import com.coderhouse.clase_09.models.Categoria;
import com.coderhouse.clase_09.models.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persistirAlumno(Alumno alumno){
        em.persist(alumno);
    }

    @Transactional
    public void persistirCurso(Curso curso){
        em.persist(curso);
    }

    @Transactional
    public void persistirCategoria(Categoria categoria){
        em.persist(categoria);
    }

    @Transactional
    public Curso getCursoById(Long cursoId) throws Exception {
        try {
            TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id", Curso.class);
            return query.setParameter("id", cursoId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("El curso no existe");
        }
    }

    @Transactional
    public Categoria getCategoriaById(Long categoriaId) throws Exception {
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT ca FROM Categoria ca WHERE ca.id = :id",
                    Categoria.class);
            return query.setParameter("id", categoriaId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Categoria no existe");
        }
    }

    @Transactional
    public void asignarCategoríaaCurso(Long cursoId, Long categoriaId) throws Exception {

        //Obtener cursos por id
        Curso curso = getCursoById(cursoId);
        if(curso == null) {
            throw new Exception("El curso con id: " + cursoId + " no existe.");
        }

        //Obtener categoria por id
        Categoria categoria = getCategoriaById(categoriaId);
        if(categoria == null) {
            throw new Exception("Categoria con id: " + categoriaId + " no existe.");
        }

        curso.setCategoria(categoria);

        //persistir datos
        em.merge(curso);
    }
}
