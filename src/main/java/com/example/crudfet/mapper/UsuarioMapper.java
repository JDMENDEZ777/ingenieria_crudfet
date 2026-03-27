package com.example.crudfet.mapper;

import com.example.crudfet.dto.UsuarioRequestDto;
import com.example.crudfet.dto.UsuarioResponseDto;
import com.example.crudfet.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDto dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.nombre());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.password()); // Aquí se encriptaría
        return usuario;
    }

    public UsuarioResponseDto toResponseDto(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
        );
    }

    public List<UsuarioResponseDto> toResponseDtoList(List<Usuario> usuarios) {
        if (usuarios == null) return null;
        return usuarios.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}