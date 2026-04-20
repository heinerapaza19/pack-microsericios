package com.upeu.producto.controller;

import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
import com.upeu.producto.service.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/productos")
public class ProductoController {

	private final ProductoService productoService;

	// ✅ LISTAR TODOS
	@GetMapping
	public ResponseEntity<List<ProductoResponse>> findAll() {
		return ResponseEntity.ok(productoService.findAll());
	}

	// ✅ CREAR
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponse create(@Valid @RequestBody ProductoRequest request) {
		return productoService.create(request);
	}



	// ✅ DETALLE (con categoría)
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> findDetalleById(@PathVariable Integer id) {
		return ResponseEntity.ok(productoService.findDetalleById(id));
	}



}