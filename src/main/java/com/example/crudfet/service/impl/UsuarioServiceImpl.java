package com.example.crudfet.service.impl;

import com.example.crudfet.dto.UsuarioRequestDto;
import com.example.crudfet.dto.UsuarioResponseDto;
import com.example.crudfet.entity.Usuario;
import com.example.crudfet.exception.RecursoNoEncontradoException;
import com.example.crudfet.mapper.UsuarioMapper;
import com.example.crudfet.repository.UsuarioRepository;
import com.example.crudfet.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Asegura que las operaciones sean atómicas
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    // Inyección de dependencias por constructor
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDto crear(UsuarioRequestDto dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario guardado = usuarioRepository.save(usuario); // ¡Aquí se guarda en MySQL!
        return usuarioMapper.toResponseDto(guardado);
    }

    @Override
    @Transactional(readOnly = true) // Optimiza para solo lectura
    public List<UsuarioResponseDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toResponseDtoList(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDto buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto actualizar(Long id, UsuarioRequestDto dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));

        // Actualizamos los campos
        usuarioExistente.setNombre(dto.nombre());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setPassword(dto.password()); // ¡Ojo encriptar!

        Usuario actualizado = usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}