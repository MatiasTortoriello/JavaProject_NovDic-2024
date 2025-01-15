package com.coderhouse.finalEcommerce.service;

import com.coderhouse.finalEcommerce.entity.Venta;
import com.coderhouse.finalEcommerce.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas(){
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id){
        return ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró venta con ID: " + id));
    }

    @Transactional
    public Venta createVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    @Transactional
    public Venta updateVenta(Long id, Venta ventaDetails){
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró venta con ID: " + id));
        venta.setCliente(ventaDetails.getCliente());
        venta.setDetalles(ventaDetails.getDetalles());

        return ventaRepository.save(venta);
    }

    public void deleteVentaById(Long id){
        if(ventaRepository.existsById(id)){
            ventaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontro venta con ID: " + id);
        }
    }
}
