package com.ventas.mapper;

import com.ventas.dto.VentaDTO;
import com.ventas.entity.Venta;

public class VentaMapper {

    public static VentaDTO toDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setId(venta.getId());
        dto.setUsuarioId(venta.getUsuarioId());
        dto.setProductoId(venta.getProductoId());
        dto.setCantidad(venta.getCantidad());
        dto.setPrecioUnitario(venta.getPrecioUnitario());
        dto.setTotal(venta.getTotal());
        dto.setEstado(venta.getEstado());
        dto.setFechaCreacion(venta.getFechaCreacion());
        dto.setFechaActualizacion(venta.getFechaActualizacion());
        return dto;
    }

    public static Venta toEntity(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setId(dto.getId());
        venta.setUsuarioId(dto.getUsuarioId());
        venta.setProductoId(dto.getProductoId());
        venta.setCantidad(dto.getCantidad());
        venta.setPrecioUnitario(dto.getPrecioUnitario());
        venta.setTotal(dto.getTotal());
        venta.setEstado(dto.getEstado());

        // ❌ NO mapear fechas aquí
        return venta;
    }
}