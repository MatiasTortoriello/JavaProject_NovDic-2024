package com.coderhouse.finalEcommerce.repository;

import com.coderhouse.finalEcommerce.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
