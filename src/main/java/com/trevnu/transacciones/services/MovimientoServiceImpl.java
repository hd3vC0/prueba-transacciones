package com.trevnu.transacciones.services;

import com.trevnu.transacciones.bl.BalanceCalculatorImpl;
import com.trevnu.transacciones.dto.MovimientoDto;
import com.trevnu.transacciones.entity.Cuenta;
import com.trevnu.transacciones.entity.Movimiento;
import com.trevnu.transacciones.exceptions.CuentaNotFoundException;
import com.trevnu.transacciones.mappers.MovimientoMapper;
import com.trevnu.transacciones.repositories.CuentaRepository;
import com.trevnu.transacciones.repositories.MovimientoRespository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientoRespository movimientoRespository;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public void create(MovimientoDto dto) {
        Cuenta cuenta = cuentaRepository.findById(dto.getNumeroCuenta().intValue())
                .orElseThrow(CuentaNotFoundException::new);
        Movimiento movimiento = Mappers.getMapper(MovimientoMapper.class).toEntity(dto);
        Long saldoFinal = new BalanceCalculatorImpl(cuenta.getSaldoInicial(), movimiento.getValor()).calculateBalance();
        if(dto.getValor()>=0){
            movimiento.setTipoMovimiento("CREDITO");
        }else{
            movimiento.setTipoMovimiento("DEBITO");
        }
        movimiento.setSaldo(saldoFinal);
        cuenta.setSaldoInicial(saldoFinal);
        movimiento.setCuenta(cuenta);

        cuentaRepository.save(cuenta);
        movimientoRespository.save(movimiento);

    }

    @Override
    public List<MovimientoDto> getAll() {
        return null;
    }

    @Override
    public void update(Integer id, MovimientoDto dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public MovimientoDto get(Integer id) {
        return null;
    }
}
