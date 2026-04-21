package com.upeu.producto.dto;

<<<<<<< HEAD
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductoResponse {
	Long id;
	String nombre;
	String descripcion;
	Long idCategoria;
	BigDecimal precio;
	Integer stock;
	CategoriaDto categoria;
}

=======
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
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
