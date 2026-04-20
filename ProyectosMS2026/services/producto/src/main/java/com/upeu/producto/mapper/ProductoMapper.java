package com.upeu.producto.mapper;

import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
import com.upeu.producto.entity.Producto;

public final class ProductoMapper {

	private ProductoMapper() {
	}

	public static Producto toEntity(ProductoRequest request) {
		return Producto.builder()
				.nombre(request.getNombre())
				.descripcion(request.getDescripcion())
				.precio(request.getPrecio())
				.idCategoria(request.getIdCategoria()) // 🔥 FIX AQUÍ
				.build();
	}

	public static ProductoResponse toResponse(Producto entity) {
		return ProductoResponse.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.precio(entity.getPrecio())
				.idCategoria(entity.getIdCategoria()) // 🔥 también aquí
				.build();
	}
}