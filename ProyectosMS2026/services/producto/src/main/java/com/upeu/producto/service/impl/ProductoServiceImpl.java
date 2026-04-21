package com.upeu.producto.service.impl;

import com.upeu.producto.client.CatalogoClient;
import com.upeu.producto.dto.CategoriaDto;
import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
<<<<<<< HEAD
import com.upeu.producto.mapper.ProductoMapper;
import com.upeu.producto.repository.ProductoRepository;
import com.upeu.producto.service.ProductoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
=======
import com.upeu.producto.entity.Producto;
import com.upeu.producto.mapper.ProductoMapper;
import com.upeu.producto.repository.ProductoRepository;
import com.upeu.producto.service.ProductoService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
public class ProductoServiceImpl implements ProductoService {

	private final ProductoRepository productoRepository;
	private final CatalogoClient catalogoClient;

	@Override
	public List<ProductoResponse> findAll() {
		return productoRepository.findAll().stream()
				.map(ProductoMapper::toResponse)
				.toList();
	}

	@Override
	public ProductoResponse create(ProductoRequest request) {
		var entity = ProductoMapper.toEntity(request);
		var saved = productoRepository.save(entity);
		return ProductoMapper.toResponse(saved);
	}

	@Override
	@Transactional(readOnly = true)
<<<<<<< HEAD
	public ProductoResponse findById(Long id) {
		var producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));
		return ProductoMapper.toResponse(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoResponse findDetalleById(Long id) {
		var producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));

		CategoriaDto categoria = catalogoClient.findCategoriaById(producto.getIdCategoria());
=======
	public ProductoResponse findDetalleById(Integer id) {

		log.info("Buscando detalle de producto con ID: {}", id);

		Producto producto = getProductoById(id.longValue());

		CategoriaDto categoria = catalogoClient.findCategoriaById(
				producto.getIdCategoria().longValue()
		);
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b

		return ProductoResponse.builder()
				.id(producto.getId())
				.nombre(producto.getNombre())
				.descripcion(producto.getDescripcion())
				.idCategoria(producto.getIdCategoria())
<<<<<<< HEAD
				.precio(producto.getPrecio())
				.stock(producto.getStock())
=======
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
				.categoria(categoria)
				.build();
	}

<<<<<<< HEAD
	@Override
	@Transactional
	public ProductoResponse update(Long id, ProductoRequest request) {
		var producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));

		producto.setNombre(request.getNombre());
		producto.setDescripcion(request.getDescripcion());
		producto.setIdCategoria(request.getIdCategoria());
		producto.setPrecio(request.getPrecio());
		producto.setStock(request.getStock());

		var saved = productoRepository.save(producto);
		return ProductoMapper.toResponse(saved);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		if (!productoRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id);
		}
		productoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public ProductoResponse descontarStock(Long id, Integer cantidad) {
		var producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));

		if (producto.getStock() < cantidad) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuficiente para producto: " + id);
		}

		producto.setStock(producto.getStock() - cantidad);
		var saved = productoRepository.save(producto);
		return ProductoMapper.toResponse(saved);
	}
}

=======
	private Producto getProductoById(Long id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	}
}
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
