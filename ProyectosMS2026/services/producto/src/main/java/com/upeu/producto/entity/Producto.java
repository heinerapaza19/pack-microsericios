package com.upeu.producto.entity;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b

@Entity
@Table(name = "productos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String nombre;

	@Column(length = 255)
	private String descripcion;

<<<<<<< HEAD
	@Column(name = "id_categoria", nullable = false)
	private Long idCategoria;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	@Column(nullable = false)
	private Integer stock;
}

=======
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	// ✅ AGREGADO (porque tu service lo usa)
	@Column(name = "id_categoria")
	private Long idCategoria;
}
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
