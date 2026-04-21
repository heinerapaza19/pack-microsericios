package com.upeu.producto.client;

import com.upeu.producto.dto.CategoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

<<<<<<< HEAD
@FeignClient(name = "catalogo")
public interface CatalogoClient {

	@GetMapping("/api/v1/categorias/{id}")
	CategoriaDto findCategoriaById(@PathVariable("id") Long id);
}

=======
@FeignClient(name = "catalogo", url = "http://localhost:8081")
public interface CatalogoClient {

    @GetMapping("/api/v1/categorias/{id}")
    CategoriaDto findCategoriaById(@PathVariable("id") Long id);
}
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
