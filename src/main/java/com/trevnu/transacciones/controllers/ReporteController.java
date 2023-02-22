package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.dto.ReporteMovimientoDto;
import com.trevnu.transacciones.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "reportes", produces = "application/json")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;
    @GetMapping("/{cuentaid}")
    public ResponseEntity<DefaultResponseDto> estadoCuenta(@PathVariable Long cuentaid,
                                                           @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") Date fecha1,
                                                           @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") Date fecha2){
        List<ReporteMovimientoDto> movimientos = reporteService.generarReporte(cuentaid, fecha1, fecha2);
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .message("Ok")
                        .statusCode(200)
                        .data(movimientos)
                        .build()
        );
    }
}
