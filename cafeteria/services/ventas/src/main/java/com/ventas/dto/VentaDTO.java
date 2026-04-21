package com.ventas.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VentaDTO {

    private Long id;
    private String usuarioId;
    private String productoId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private String estado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}