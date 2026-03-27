package com.example.crudfet.dto;

public record UsuarioResponseDto(
        Long id,
        String nombre,
        String email
        // ¡NUNCA devolvemos la contraseña aquí por seguridad!
) {}