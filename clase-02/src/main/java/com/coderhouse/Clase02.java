package com.coderhouse;

import java.util.ArrayList;
import java.util.List;

public class Clase02 {
	


	public static void main(String[] args) {
		/*
		int numeroA = 1;
		int numeroB = 2;

		if(numeroA > numeroB) {
			System.out.println("El número " + numeroA + " es mayor que " + numeroB);
		} else {
			System.out.println("El número " + numeroB + " es mayor que " + numeroA);
		}*/
		
		/*int diaDeLaSemana = 1;
		
		if (diaDeLaSemana == 10) {
			System.out.println("El día de la semana es Lunes");
		} else if (diaDeLaSemana == 2) {
			System.out.println("El día de la semana es Martes");
		} else if (diaDeLaSemana == 3) {
			System.out.println("El día de la semana es Miércoles");
		} else if (diaDeLaSemana == 4) {
			System.out.println("El día de la semana es Jueves");
		} else if (diaDeLaSemana == 5) {
			System.out.println("El día de la semana es Viernes");
		} else if (diaDeLaSemana == 2) {
			System.out.println("El día de la semana es Sábado");
		} else if (diaDeLaSemana == 2) {
			System.out.println("El día de la semana es Domingo");
		} else {
			System.out.println("No es número correcto");
		}*/
		
		//OPERADOR TERNARIO
		/*
		int numeroA = 1;
		int numeroB = 2;
		
		boolean condicion = numeroA > numeroB;
		
		boolean resultado = condicion ? true : false;*/
		
		//DATOS ALEATORIOS
		
		int random = 0;
		//random = Math.random();
		//System.out.println(random);
		
		int minimo = 1;
		
		
		int maximo = 6;
		
		int rango = (maximo - minimo) + 1;
		
		random = (int) (Math.random() * rango )+1;
		
		System.out.println(random);
		}
	
	///CLASE LIST
	
	/*List<String> listaDeNombres = new ArrayList<>();
	
	listaDeNombres.add("Matias");*/
 }

