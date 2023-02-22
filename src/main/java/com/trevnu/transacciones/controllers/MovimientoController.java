package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.dto.MovimientoDto;
import com.trevnu.transacciones.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "movimientos", produces = "application/json")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;
    @PostMapping
    public ResponseEntity<DefaultResponseDto> create(@Valid @RequestBody MovimientoDto movimientoDto){
        movimientoService.create(movimientoDto);
        return ResponseEntity.ok().build();
    }
}
