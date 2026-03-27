package com.example.crudfet.service;

import com.example.crudfet.dto.UsuarioRequestDto;
import com.example.crudfet.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDto crear(UsuarioRequestDto dto);
    List<UsuarioResponseDto> listar();
    UsuarioResponseDto buscarPorId(Long id);
    UsuarioResponseDto actualizar(Long id, UsuarioRequestDto dto);
    void eliminar(Long id);
}