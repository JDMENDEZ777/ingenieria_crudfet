package com.example.crudfet.controller;

import com.example.crudfet.dto.UsuarioRequestDto;
import com.example.crudfet.dto.UsuarioResponseDto;
import com.example.crudfet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // Puerta de entrada diferente a /api/productos
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección de dependencias
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Código 201
    public UsuarioResponseDto crear(@Valid @RequestBody UsuarioRequestDto dto) {
        return usuarioService.crear(dto);
    }

    @GetMapping
    public List<UsuarioResponseDto> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto actualizar(@PathVariable Long id,
                                         @Valid @RequestBody UsuarioRequestDto dto) {
        return usuarioService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Código 204
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}