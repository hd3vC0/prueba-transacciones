package com.trevnu.transacciones.mappers;

import com.trevnu.transacciones.dto.MovimientoDto;
import com.trevnu.transacciones.entity.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(target = "cuenta", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "saldo", ignore = true)
    @Mapping(target = "tipoMovimiento", ignore = true)
    Movimiento toEntity(MovimientoDto dto);
    @Mapping(source = "cuenta.numero", target = "numeroCuenta")
    MovimientoDto toDto(Movimiento entity);
}
