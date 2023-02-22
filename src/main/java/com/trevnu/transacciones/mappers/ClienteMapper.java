package com.trevnu.transacciones.mappers;

import com.trevnu.transacciones.dto.ClienteDto;
import com.trevnu.transacciones.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mapping(target = "estado", ignore = true)
    Cliente toEntity(ClienteDto clienteDto);
    ClienteDto toDto(Cliente entity);
}
