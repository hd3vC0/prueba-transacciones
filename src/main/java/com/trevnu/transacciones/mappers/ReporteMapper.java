package com.trevnu.transacciones.mappers;

import com.trevnu.transacciones.dto.ReporteMovimientoDto;
import com.trevnu.transacciones.entity.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReporteMapper {
    @Mapping(source = "cuenta.cliente.nombre", target = "cliente")
    @Mapping(source = "cuenta.numero", target = "numeroCuenta")
    @Mapping(source = "cuenta.tipo", target = "tipo")
    @Mapping(source = "cuenta.estado", target = "estado")
    @Mapping(source = "valor", target = "movimiento")
    @Mapping(source = "saldo", target = "saldoDisponible")
    ReporteMovimientoDto toDto(Movimiento entity);
}
