package com.example.crudfet.dto;

public record ProductoResponseDto(
        Long id,
        String nombre,
        Double precio,
        Integer stock
) {
}
