package com.example.crudfet.service;

import com.example.crudfet.dto.ProductoRequestDto;
import com.example.crudfet.dto.ProductoResponseDto;

import java.util.List;

public interface ProductoService {

    ProductoResponseDto crear(ProductoRequestDto dto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);

    void eliminar(Long id);
}
