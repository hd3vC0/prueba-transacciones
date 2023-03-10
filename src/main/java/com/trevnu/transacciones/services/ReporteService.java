package com.trevnu.transacciones.services;

import com.trevnu.transacciones.dto.ReporteMovimientoDto;

import java.util.Date;
import java.util.List;

public interface ReporteService {
    List<ReporteMovimientoDto> generarReporte(Long numeroCuenta, Date fecha1, Date fecha2);
}
