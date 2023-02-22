package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.DefaultResponseDto;
import com.trevnu.transacciones.exceptions.BalanceNotAvailableException;
import com.trevnu.transacciones.exceptions.ClienteNotFoundException;
import com.trevnu.transacciones.exceptions.CuentaNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponseDto> hanlderValidation(MethodArgumentNotValidException e){
        StringBuilder sb = new StringBuilder();
        for (ObjectError oe:e.getAllErrors()) {
            sb.append(oe.getDefaultMessage());
            sb.append("\n");
        }

        return ResponseEntity.badRequest().body(
                DefaultResponseDto.builder()
                        .statusCode(400)
                        .message(sb.toString())
                        .build()
        );
    }

    @ExceptionHandler({
            ClienteNotFoundException.class,
            CuentaNotFoundException.class
    })
    public ResponseEntity<DefaultResponseDto> hanlderClienteNotFound(RuntimeException e){
        return ResponseEntity.status(404).body(
                DefaultResponseDto.builder()
                        .statusCode(404)
                        .message(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(BalanceNotAvailableException.class)
    public ResponseEntity<DefaultResponseDto> hanlderBalanceNotAvailable(BalanceNotAvailableException e){
        return ResponseEntity.internalServerError().body(
                DefaultResponseDto.builder()
                        .statusCode(500)
                        .message(e.getMessage())
                        .build()
        );
    }
}
