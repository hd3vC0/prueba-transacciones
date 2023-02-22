package com.trevnu.transacciones.bl;

import com.trevnu.transacciones.exceptions.BalanceNotAvailableException;

public class BalanceCalculatorImpl implements BalanceCalculator{
    private Long balance;
    private Long value;

    public BalanceCalculatorImpl(Long balance, Long value) {
        this.balance = balance;
        this.value = value;
    }

    @Override
    public Long calculateBalance() {
        Long res = balance + value;
        if(res<0)
            throw new BalanceNotAvailableException();

        return balance+value;
    }
}
