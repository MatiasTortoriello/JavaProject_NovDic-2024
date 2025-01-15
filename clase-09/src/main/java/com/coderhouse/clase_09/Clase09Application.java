package com.coderhouse.clase_09;

import com.coderhouse.clase_09.dao.DaoFactory;
import com.coderhouse.clase_09.models.Alumno;
import com.coderhouse.clase_09.models.Categoria;
import com.coderhouse.clase_09.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase09Application implements CommandLineRunner {

	@Autowired
	DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(Clase09Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try{

			Categoria categoria1 = new Categoria("Programación Frontend");
			Categoria categoria2 = new Categoria("Programación Backend");
			Categoria categoria3 = new Categoria("Data Science");

			Curso curso1 = new Curso("Java");
			Curso curso2 = new Curso("ReactJS");
			Curso curso3 = new Curso("JavaScript");
			Curso curso4 = new Curso("NodeJS");

			Alumno alumno1 = new Alumno("Marcelo", "Carabajal", 11111111, "1000");
			Alumno alumno2 = new Alumno("Dario", "Lencina", 22222222, "1001");
			Alumno alumno3 = new Alumno("Sebastian", "Quesada", 33333333, "1002");
			Alumno alumno4 = new Alumno("Martin", "Carabajal", 44444444, "1003");

			dao.persistirCategoria(categoria1);
			dao.persistirCategoria(categoria2);
			dao.persistirCategoria(categoria3);

			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);

			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);

			dao.asignarCategoríaaCurso(curso1.getId(), categoria2.getId());
			dao.asignarCategoríaaCurso(curso2.getId(), categoria1.getId());
			dao.asignarCategoríaaCurso(curso3.getId(), categoria1.getId());
			dao.asignarCategoríaaCurso(curso4.getId(), categoria2.getId());

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
