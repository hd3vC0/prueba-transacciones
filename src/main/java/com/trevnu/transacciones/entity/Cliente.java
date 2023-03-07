package com.trevnu.transacciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "clientes")
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String contrasena;
    @Column(nullable = true, columnDefinition = "bit(1) default true")
    private Boolean estado = true;



}
