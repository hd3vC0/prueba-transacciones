package com.trevnu.transacciones.exceptions;

public class BalanceNotAvailableException extends RuntimeException{
    public BalanceNotAvailableException() {
        super("Saldo no disponible");
    }
}
