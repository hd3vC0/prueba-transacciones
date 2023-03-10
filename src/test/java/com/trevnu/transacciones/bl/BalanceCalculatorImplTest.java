package com.trevnu.transacciones.bl;

import com.trevnu.transacciones.exceptions.BalanceNotAvailableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class BalanceCalculatorImplTest {

    @Test
    void calcular_balance_ok(){
        BalanceCalculator balanceCalculator = new BalanceCalculatorImpl(10L, -10L);
        assertEquals("Movimiento de debito", 0L, balanceCalculator.calculateBalance());
    }

    @Test
    void calcular_balance_exception(){
        BalanceCalculator balanceCalculator = new BalanceCalculatorImpl(10L, -11L);
        assertThrows(BalanceNotAvailableException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                balanceCalculator.calculateBalance();
            }
        });
    }
}
