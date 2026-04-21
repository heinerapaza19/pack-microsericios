package com.upeu.producto.service.impl;

import com.upeu.producto.client.CatalogoClient;
import com.upeu.producto.dto.CategoriaDto;
import com.upeu.producto.dto.ProductoRequest;
import com.upeu.producto.dto.ProductoResponse;
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

		return ProductoResponse.builder()
				.id(producto.getId())
				.nombre(producto.getNombre())
				.descripcion(producto.getDescripcion())
				.idCategoria(producto.getIdCategoria())
				.precio(producto.getPrecio())
				.stock(producto.getStock())
				.categoria(categoria)
				.build();
	}

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

