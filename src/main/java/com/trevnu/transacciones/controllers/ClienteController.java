package com.trevnu.transacciones.controllers;


import com.trevnu.transacciones.dto.ClienteDto;
import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clientes", produces = "application/json")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping({"", "/"})
    public ResponseEntity<DefaultResponseDto> getAll(){
        List<ClienteDto> list = clienteService.getAll();
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .message("Ok")
                        .statusCode(200)
                        .data(list)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> getCliente(@PathVariable Integer id){
        ClienteDto cliente = clienteService.get(id);
        return ResponseEntity.ok(
                DefaultResponseDto.builder()
                        .statusCode(200)
                        .message("Ok")
                        .data(cliente)
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ClienteDto clienteDto){
        clienteService.create(clienteDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ClienteDto cliente){
        clienteService.update(id, cliente);
        return ResponseEntity.ok().build();
    }

}
