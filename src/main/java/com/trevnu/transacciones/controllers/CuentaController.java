package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.CuentaDto;
import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cuentas", produces = "application/json")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<DefaultResponseDto> create(@Valid @RequestBody CuentaDto cuentaDto){
        cuentaService.create(cuentaDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<DefaultResponseDto> getAll(){
        List<CuentaDto> list = cuentaService.getAll();
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .data(list)
                        .message("Ok")
                        .statusCode(200)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> get(@PathVariable Integer id){
        CuentaDto cuentaDto = cuentaService.get(id);
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .statusCode(200)
                        .message("Ok")
                        .data(cuentaDto)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> delete(@PathVariable Integer id){
        cuentaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> update(@PathVariable Integer id, @RequestBody CuentaDto cuentaDto){
        cuentaService.update(id, cuentaDto);
        return ResponseEntity.ok().build();
    }
}
