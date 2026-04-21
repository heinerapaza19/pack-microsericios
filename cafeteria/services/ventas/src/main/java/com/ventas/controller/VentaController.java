package com.ventas.controller;

import com.ventas.dto.VentaDTO;
import com.ventas.service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @PostMapping
    public VentaDTO crear(@RequestBody VentaDTO dto) {
        return service.crearVenta(dto);
    }

    @GetMapping
    public List<VentaDTO> listar() {
        return service.listarVentas();
    }

    @GetMapping("/{id}")
    public VentaDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public VentaDTO actualizar(@PathVariable Long id, @RequestBody VentaDTO dto) {
        return service.actualizarVenta(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarVenta(id);
    }
}