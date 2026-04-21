package com.ventas.service.impl;

import com.ventas.dto.VentaDTO;
import com.ventas.entity.Venta;
import com.ventas.mapper.VentaMapper;
import com.ventas.repository.VentaRepository;
import com.ventas.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository repository;

    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO dto) {
        Venta venta = VentaMapper.toEntity(dto);

        venta.setTotal(venta.getCantidad() * venta.getPrecioUnitario());

        return VentaMapper.toDTO(repository.save(venta));
    }

    @Override
    public List<VentaDTO> listarVentas() {
        return repository.findAll()
                .stream()
                .map(VentaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VentaDTO obtenerPorId(Long id) {
        Venta venta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        return VentaMapper.toDTO(venta);
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO dto) {

        Venta venta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        venta.setUsuarioId(dto.getUsuarioId());
        venta.setProductoId(dto.getProductoId());
        venta.setCantidad(dto.getCantidad());
        venta.setPrecioUnitario(dto.getPrecioUnitario());
        venta.setTotal(dto.getCantidad() * dto.getPrecioUnitario());
        venta.setEstado(dto.getEstado());

        return VentaMapper.toDTO(repository.save(venta));
    }

    @Override
    public void eliminarVenta(Long id) {
        repository.deleteById(id);
    }
}