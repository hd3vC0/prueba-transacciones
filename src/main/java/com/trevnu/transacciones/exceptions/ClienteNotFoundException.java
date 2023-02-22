package com.trevnu.transacciones.exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException() {
        super("Cliente no encontrado");
    }
}
