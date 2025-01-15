package com.coderhouse.clase_12.service;

import com.coderhouse.clase_12.dto.InscripcionDTO;
import com.coderhouse.clase_12.model.Alumno;
import com.coderhouse.clase_12.model.Curso;
import com.coderhouse.clase_12.repository.AlumnoRepository;
import com.coderhouse.clase_12.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public List<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }

    @Transactional
    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    @Transactional
    public Alumno updateAlumnoById(Long id, Alumno alumnoDetails) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
                alumno.setNombre(alumnoDetails.getNombre());
                alumno.setApellido(alumnoDetails.getApellido());

                if(alumnoDetails.getDni() != 0) {
                    alumno.setDni(alumnoDetails.getDni());
                }

                if(alumnoDetails.getLegajo() != null && !alumnoDetails.getLegajo().isEmpty()) {
                    alumno.setLegajo(alumnoDetails.getLegajo());
                }
                return alumnoRepository.save(alumno);
    }

    public void deleteAlumnoById(Long id) {
        if(!alumnoRepository.existsById(id)) {
            throw new IllegalArgumentException("Alumno no encontrado");
        }

        alumnoRepository.deleteById(id);
    }

    @Transactional
    public Alumno inscribirAlumnoACursos(InscripcionDTO inscripcionDTO) {
        Alumno alumno = alumnoRepository.findById(inscripcionDTO.getAlumnoId())
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

        for (Long cursoId : inscripcionDTO.getCursosId()) {
            Curso curso = cursoRepository.findById(cursoId)
                    .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

            alumno.getCursos().add(curso);
        }

        return alumnoRepository.save(alumno);
    }
}
