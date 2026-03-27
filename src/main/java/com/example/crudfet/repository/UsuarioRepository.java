package com.example.crudfet.repository;

import com.example.crudfet.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método mágico extra para buscar por correo (útil para login)
    Optional<Usuario> findByEmail(String email);
}