package com.perfulandia.inventario.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private Integer idInventario;
    
    private Integer idProducto;
    private Integer cantidadDisponible;
    private String ubicacionBodega;
}
