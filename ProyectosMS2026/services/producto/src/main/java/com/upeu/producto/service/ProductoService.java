package com.upeu.producto.service;

import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
import java.util.List;

public interface ProductoService {
	List<ProductoResponse> findAll();

	ProductoResponse create(ProductoRequest request);

	ProductoResponse findDetalleById(Integer id);
}

