package com.upeu.producto.mapper;

import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
import com.upeu.producto.entity.Producto;

public final class ProductoMapper {
<<<<<<< HEAD
=======

>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
	private ProductoMapper() {
	}

	public static Producto toEntity(ProductoRequest request) {
		return Producto.builder()
				.nombre(request.getNombre())
				.descripcion(request.getDescripcion())
<<<<<<< HEAD
				.idCategoria(request.getIdCategoria())
				.precio(request.getPrecio())
				.stock(request.getStock())
=======
				.precio(request.getPrecio())
				.idCategoria(request.getIdCategoria()) // 🔥 FIX AQUÍ
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
				.build();
	}

	public static ProductoResponse toResponse(Producto entity) {
		return ProductoResponse.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
<<<<<<< HEAD
				.idCategoria(entity.getIdCategoria())
				.precio(entity.getPrecio())
				.stock(entity.getStock())
				.build();
	}
}

=======
				.precio(entity.getPrecio())
				.idCategoria(entity.getIdCategoria()) // 🔥 también aquí
				.build();
	}
}
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
