package com.coderhouse.finalEcommerce.service;

import com.coderhouse.finalEcommerce.entity.VentaDetalle;
import com.coderhouse.finalEcommerce.repository.VentaDetalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    public List<VentaDetalle> getAllVentaDetalles(){
        return ventaDetalleRepository.findAll();
    }

    public VentaDetalle getVentaDetalleById(Long id){
        return ventaDetalleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró detalle de venta con ID: " + id));
    }

    @Transactional
    public VentaDetalle createVentaDetalle(VentaDetalle venta){
        return ventaDetalleRepository.save(venta);
    }

    @Transactional
    public VentaDetalle updateVentaDetalle(Long id, VentaDetalle ventaDetails){
        VentaDetalle ventaDetalle = ventaDetalleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró detalle de venta con ID: " + id));
        ventaDetalle.setCantidad(ventaDetails.getCantidad());
        ventaDetalle.setProducto(ventaDetails.getProducto());
        ventaDetalle.setCantidad(ventaDetails.getCantidad());

        return ventaDetalleRepository.save(ventaDetalle);
    }

    public void deleteVentaDetalleById(Long id){
        if(ventaDetalleRepository.existsById(id)){
            ventaDetalleRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontro detalle de venta con ID: " + id);
        }
    }
}
