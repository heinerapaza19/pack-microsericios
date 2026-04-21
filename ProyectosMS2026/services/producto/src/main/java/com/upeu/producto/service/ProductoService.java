package com.upeu.producto.service;

import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
import java.util.List;

public interface ProductoService {
	List<ProductoResponse> findAll();

	ProductoResponse create(ProductoRequest request);

<<<<<<< HEAD
	ProductoResponse findById(Long id);

	ProductoResponse findDetalleById(Long id);

	ProductoResponse update(Long id, ProductoRequest request);

	void delete(Long id);

	ProductoResponse descontarStock(Long id, Integer cantidad);
=======
	ProductoResponse findDetalleById(Integer id);
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
}

