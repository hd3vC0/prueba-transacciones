package com.trevnu.transacciones.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ReporteMovimientoDto {
    private Date fecha;
    private String cliente;
    private Long numeroCuenta;
    private String tipo;
    private Boolean estado;
    private Long movimiento;
    private Long saldoDisponible;
}
