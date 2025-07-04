package com.perfulandia.inventario.services;

import com.perfulandia.inventario.dto.InventarioDTO;
import com.perfulandia.inventario.models.Inventario;
import com.perfulandia.inventario.repository.InventarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioServiceTest {

    @Mock
    private InventarioRepository repository;

    @InjectMocks
    private InventarioService service;

    public InventarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarInventario() {
        InventarioDTO dto = new InventarioDTO();
        dto.setIdProducto(3);
        dto.setCantidadDisponible(100);
        dto.setUbicacionBodega("Central");

        Inventario entidad = new Inventario();
        entidad.setIdInventario(1);
        entidad.setIdProducto(dto.getIdProducto());
        entidad.setCantidadDisponible(dto.getCantidadDisponible());
        entidad.setUbicacionBodega(dto.getUbicacionBodega());

        when(repository.save(any(Inventario.class))).thenReturn(entidad);

        InventarioDTO resultado = service.guardar(dto);

        assertNotNull(resultado);
        assertEquals(3, resultado.getIdProducto());
        assertEquals(100, resultado.getCantidadDisponible());
        assertEquals("Central", resultado.getUbicacionBodega());
    }
}
