package com.trevnu.transacciones.exceptions;

public class CuentaNotFoundException extends RuntimeException{
    public CuentaNotFoundException() {
        super("La cuenta no existe");
    }
}
