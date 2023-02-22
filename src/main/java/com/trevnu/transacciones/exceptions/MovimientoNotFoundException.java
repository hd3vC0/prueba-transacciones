package com.trevnu.transacciones.exceptions;

public class MovimientoNotFoundException extends RuntimeException{

    public MovimientoNotFoundException() {
        super("El movimiento no existe");
    }
}
