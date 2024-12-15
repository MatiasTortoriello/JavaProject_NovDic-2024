package com.coderhouse.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private Long id;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String direccion;
	
	private List<Producto> productos = new ArrayList<>();
	
}
