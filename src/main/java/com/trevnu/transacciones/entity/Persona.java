package com.trevnu.transacciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private String identificacion;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;
}
