package com.coderhouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.entities.Cliente;
import com.coderhouse.entities.Producto;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			
			Producto producto1 = new Producto("Teclado Gamer", "Logitech", 200.00);
			Producto producto2 = new Producto("Auriculares", "RedDragon", 350.00);
			Producto producto3 = new Producto("Mouse Gamer", "Razer", 50.00);
			
			
			Cliente cliente1 = new Cliente("Matias", "Tortoriello", 35533516, "Juncal 844");
			Cliente cliente2 = new Cliente("Alejandro", "Di Stefano", 27037032, "Calle Falsa 123");
			Cliente cliente3 = new Cliente("Ysela", "Creyó", 1234567, "Direccion Sinnumero" );
			
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}


}
