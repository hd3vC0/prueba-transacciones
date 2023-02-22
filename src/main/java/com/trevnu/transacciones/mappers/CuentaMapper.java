package com.trevnu.transacciones.mappers;

import com.trevnu.transacciones.dto.CuentaDto;
import com.trevnu.transacciones.entity.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    @Mapping(source = "cliente.id", target = "clienteid")
    CuentaDto toDto(Cuenta entity);
    @Mapping(target = "cliente", ignore = true)
    Cuenta toEntity(CuentaDto dto);
}
