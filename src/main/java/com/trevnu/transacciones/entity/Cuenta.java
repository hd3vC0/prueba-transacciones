package com.trevnu.transacciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(unique = true, nullable = false)
    private Long numero;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private Long saldoInicial;
    @Column(nullable = false, columnDefinition = "bit(1) default 1")
    private Boolean estado;
    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

}
