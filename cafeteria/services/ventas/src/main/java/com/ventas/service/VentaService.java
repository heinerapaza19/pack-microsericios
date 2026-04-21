package com.ventas.service;

import com.ventas.dto.VentaDTO;
import java.util.List;

public interface VentaService {

    VentaDTO crearVenta(VentaDTO dto);

    List<VentaDTO> listarVentas();

    VentaDTO obtenerPorId(Long id);

    VentaDTO actualizarVenta(Long id, VentaDTO dto);

    void eliminarVenta(Long id);
}