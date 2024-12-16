package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.entities.Cliente;
import com.coderhouse.entities.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional	
	public void persistenciaClientes(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	@Transactional	
	public void persistenciaProductos(Producto producto) {
		entityManager.persist(producto);
	}
}
