package com.coderhouse.objetos;

public class Perro {
	
	//Constantes
	private static final int EDAD_MAXIMA = 35;
	
	String mensajeDeError = "El perro no vive más de " + EDAD_MAXIMA + " años de edad.";
	
	//Variables de instancia o Atributos del objeto
	String nombre;
	String raza;
	String color;
	String tamanio;
	Integer edad;
	
	//Métodos
	public void ladrar(){
		System.out.println("El perro está ladrando");
	}
	
	public void caminar() {
		System.out.println("El perro está caminando");
	}
	
	public void comer() {
		System.out.println("El perro está comiendo");
	}

	
	//Getters y Setters
	
	public String getNombre() {
		return this.nombre;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

/*@Override
public String toString() {
	return "Perro [nombre="
}*/
