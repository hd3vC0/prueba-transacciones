package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.dto.MovimientoDto;
import com.trevnu.transacciones.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<DefaultResponseDto> getAll(){
        List<MovimientoDto> movimientos = movimientoService.getAll();
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .data(movimientos)
                        .statusCode(200)
                        .message("Ok")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> get(@PathVariable Integer id){
        MovimientoDto movimientoDto = movimientoService.get(id);
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .statusCode(200)
                        .message("Ok")
                        .data(movimientoDto)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> delete(@PathVariable Integer id){
        movimientoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> update(@PathVariable Integer id, @RequestBody MovimientoDto movimientoDto){
        movimientoService.update(id, movimientoDto);
        return ResponseEntity.ok().build();
    }
}
