package com.example.crudfet.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios") // Hibernate creará esta tabla automáticamente
@Data // Genera getters, setters, toString, etc. automáticamente
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100) // unique=true para evitar correos duplicados
    private String email;

    @Column(nullable = false)
    private String password; // ¡Cuidado! En producción esto *siempre* debe ir encriptado.
}
