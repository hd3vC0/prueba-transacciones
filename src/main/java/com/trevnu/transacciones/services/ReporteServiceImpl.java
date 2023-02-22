package com.trevnu.transacciones.services;

import com.trevnu.transacciones.dto.ReporteMovimientoDto;
import com.trevnu.transacciones.mappers.ReporteMapper;
import com.trevnu.transacciones.repositories.ReporteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {


    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public List<ReporteMovimientoDto> generarReporte(Long numeroCuenta, Date fecha1, Date fecha2) {
        ReporteMapper mapper = Mappers.getMapper(ReporteMapper.class);
        return reporteRepository.findMovementRange(numeroCuenta, fecha1, fecha2)
                .stream().map(mapper::toDto)
                .toList();
    }
}
