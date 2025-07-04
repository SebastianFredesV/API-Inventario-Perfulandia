package com.perfulandia.inventario.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class InventarioDTO extends RepresentationModel<InventarioDTO> {
    private Integer idInventario;
    
    private Integer idProducto;
    private Integer cantidadDisponible;
    private String ubicacionBodega;
}
