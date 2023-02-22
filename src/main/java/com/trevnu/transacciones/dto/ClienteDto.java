package com.trevnu.transacciones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDto {
    private Integer id;
    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank(message = "Genero es requerido")
    @Pattern(regexp = "^Masculino|Femenino$", message = "Genero invalido, valores posibles: Masculino, Femenino")
    private String genero;
    @NotNull(message = "Edad es requerido")
    @Min(value = 18, message = "Debe ser mayor de edad")
    private Integer edad;
    @NotBlank(message = "Identificación es requerido")
    private String identificacion;
    @NotBlank(message = "Dirección es requerido")
    private String direccion;
    @NotBlank(message = "Dirección es requerido")
    private String telefono;
    @NotBlank(message = "Contraseña es requerido")
    private String contrasena;

}
