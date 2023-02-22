package com.trevnu.transacciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String tipoMovimiento;
    @Column(nullable = false)
    private Long valor;
    @Column(nullable = false)
    private Long saldo;
    @OneToOne
    @JoinColumn(nullable = false)
    private Cuenta cuenta;
}
