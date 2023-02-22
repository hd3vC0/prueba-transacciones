package com.trevnu.transacciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDto {
    @NotNull(message = "Número de cuenta es requerido")
    private Long numero;
    @NotBlank(message = "Tipo de cuenta es requerido")
    @Pattern(regexp = "^AHORRO|CORRIENTE$", message = "Tipo de cuenta invalido, valores permitidos: AHORRO, CORRIENTE")
    private String tipo;
    @NotNull(message = "Saldo inicial es requerido")
    private Long saldoInicial;
    @NotNull(message = "Estado es requerido")
    private Boolean estado;
    @NotNull(message = "Id cliente es requerido")
    private Integer clienteid;
}
