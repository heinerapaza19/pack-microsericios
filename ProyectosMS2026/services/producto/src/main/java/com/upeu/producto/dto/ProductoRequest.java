package com.upeu.producto.dto;

import jakarta.validation.constraints.DecimalMin;
<<<<<<< HEAD
import jakarta.validation.constraints.Min;
=======
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductoRequest {
<<<<<<< HEAD
=======

>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
	@NotBlank
	String nombre;

	String descripcion;

	@NotNull
<<<<<<< HEAD
	Long idCategoria;

	@NotNull
=======
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
	@DecimalMin("0.00")
	BigDecimal precio;

	@NotNull
<<<<<<< HEAD
	@Min(0)
	Integer stock;
}

=======
	Long idCategoria; // 🔥 ESTO FALTABA
}
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
