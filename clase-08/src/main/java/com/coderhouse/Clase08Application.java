package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.entities.Cliente;
import com.coderhouse.entities.Producto;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner {

	@Autowired
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			//Productos
			Producto producto1 = new Producto("Teclado Gamer", "Logitech", 200.00);
			dao.persistenciaProductos(producto1);
			Producto producto2 = new Producto("Auriculares", "RedDragon", 350.00);
			dao.persistenciaProductos(producto2);
			Producto producto3 = new Producto("Mouse Gamer", "Razer", 50.00);
			dao.persistenciaProductos(producto3);
			
			//Clientes
			Cliente cliente1 = new Cliente("Matias", "Tortoriello", 35533516, "Juncal 844");
			dao.persistenciaClientes(cliente1);
			Cliente cliente2 = new Cliente("Alejandro", "Di Stefano", 27037032, "Calle Falsa 123");
			dao.persistenciaClientes(cliente2);
			Cliente cliente3 = new Cliente("Ysela", "Creyó", 1234567, "Direccion SinNumero" );
			dao.persistenciaClientes(cliente3);

			
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}


}
