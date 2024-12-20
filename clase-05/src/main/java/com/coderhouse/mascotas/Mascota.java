package com.coderhouse.mascotas;

public class Mascota {
	
	private static final int EDAD_MAXIMA = 35;
	
	String mensajeDeError = "La mascota no vive más de " + EDAD_MAXIMA + " años de edad.";
	
	private String nombre;
	private String raza;
	private String color;
	private String tamanio;
	private Integer edad;
	
	public void caminar() {
		System.out.println("La mascota está caminando");
	}
	
	public void comer() {
		System.out.println("La mascota está comiendo");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() { 
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Integer getEdad() {
		return edad;
	}

	
	public void setEdad(Integer edad) throws Exception {
		if (edad > EDAD_MAXIMA) {
			throw new Exception(mensajeDeError);
		} else {
			this.edad = edad;
		}

	}
	
	
	
}
