package com.perfulandia.inventario.repository;

import com.perfulandia.inventario.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    Optional<Inventario> findByIdProducto(Integer idProducto);
}
