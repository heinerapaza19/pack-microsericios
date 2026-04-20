package com.upeu.producto.service.impl;

import com.upeu.producto.client.CatalogoClient;
import com.upeu.producto.dto.CategoriaDto;
import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
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
	public ProductoResponse findDetalleById(Integer id) {

		log.info("Buscando detalle de producto con ID: {}", id);

		Producto producto = getProductoById(id.longValue());

		CategoriaDto categoria = catalogoClient.findCategoriaById(
				producto.getIdCategoria().longValue()
		);

		return ProductoResponse.builder()
				.id(producto.getId())
				.nombre(producto.getNombre())
				.descripcion(producto.getDescripcion())
				.idCategoria(producto.getIdCategoria())
				.categoria(categoria)
				.build();
	}

	private Producto getProductoById(Long id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	}
}