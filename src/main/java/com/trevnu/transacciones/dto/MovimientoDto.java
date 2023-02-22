package com.trevnu.transacciones.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class MovimientoDto {

    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    @NotNull(message = "Valor es requerido")
    private Long valor;
    private Long saldo;
    @NotNull(message = "Número de cuenta es requerido")
    private Long numeroCuenta;
}
