package com.perfulandia.inventario.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;

    private Integer idProducto;
    private Integer cantidadDisponible;
    private String ubicacionBodega;
}
