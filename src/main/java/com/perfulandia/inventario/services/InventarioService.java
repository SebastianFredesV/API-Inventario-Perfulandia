package com.perfulandia.inventario.services;

import com.perfulandia.inventario.dto.InventarioDTO;
import com.perfulandia.inventario.models.Inventario;
import com.perfulandia.inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repository;

    public InventarioDTO guardar(InventarioDTO dto) {
        Inventario inventario = toEntity(dto);
        return toDTO(repository.save(inventario));
    }

    public List<InventarioDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<InventarioDTO> obtenerPorId(Integer id) {
        return repository.findById(id).map(this::toDTO);
    }

    public Optional<InventarioDTO> obtenerPorProducto(Integer idProducto) {
        return repository.findByIdProducto(idProducto).map(this::toDTO);
    }

    public Optional<InventarioDTO> actualizar(Integer id, InventarioDTO dto) {
        return repository.findById(id).map(inventario -> {
            inventario.setIdProducto(dto.getIdProducto());
            inventario.setCantidadDisponible(dto.getCantidadDisponible());
            inventario.setUbicacionBodega(dto.getUbicacionBodega());
            return toDTO(repository.save(inventario));
        });
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private InventarioDTO toDTO(Inventario entity) {
        InventarioDTO dto = new InventarioDTO();
        dto.setIdInventario(entity.getIdInventario());
        dto.setIdProducto(entity.getIdProducto());
        dto.setCantidadDisponible(entity.getCantidadDisponible());
        dto.setUbicacionBodega(entity.getUbicacionBodega());
        return dto;
    }

    private Inventario toEntity(InventarioDTO dto) {
        Inventario entity = new Inventario();
        entity.setIdInventario(dto.getIdInventario());
        entity.setIdProducto(dto.getIdProducto());
        entity.setCantidadDisponible(dto.getCantidadDisponible());
        entity.setUbicacionBodega(dto.getUbicacionBodega());
        return entity;
    }
}
