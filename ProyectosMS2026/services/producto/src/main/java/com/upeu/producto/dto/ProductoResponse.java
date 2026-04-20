package com.upeu.producto.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {

	private Long id;              // ✅ antes Integer
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
	private Long idCategoria;    // ✅ antes Integer
	private CategoriaDto categoria;
}