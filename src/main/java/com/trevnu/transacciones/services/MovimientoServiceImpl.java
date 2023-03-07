package com.trevnu.transacciones.services;

import com.trevnu.transacciones.bl.BalanceCalculatorImpl;
import com.trevnu.transacciones.dto.MovimientoDto;
import com.trevnu.transacciones.entity.Cuenta;
import com.trevnu.transacciones.entity.Movimiento;
import com.trevnu.transacciones.exceptions.CuentaNotFoundException;
import com.trevnu.transacciones.exceptions.MovimientoNotFoundException;
import com.trevnu.transacciones.mappers.MovimientoMapper;
import com.trevnu.transacciones.repositories.CuentaRepository;
import com.trevnu.transacciones.repositories.MovimientoRespository;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientoRespository movimientoRespository;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    @Transactional
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
        List<Movimiento> list = new ArrayList<>();
        movimientoRespository.findAll().forEach(list::add);
        MovimientoMapper mapper = Mappers.getMapper(MovimientoMapper.class);
        return list.stream().map(mapper::toDto).toList();
    }

    @Override
    public void update(Integer id, MovimientoDto dto) {
        Movimiento movimiento = movimientoRespository.findById(id.longValue()).orElseThrow(MovimientoNotFoundException::new);
        BeanWrapper wrapper = new BeanWrapperImpl(dto);
        List<String> props = Arrays.stream(wrapper.getPropertyDescriptors())
                .filter(x -> wrapper.getPropertyValue(x.getName()) == null)
                .map(x -> x.getName()).toList();
        BeanUtils.copyProperties(dto, movimiento, props.toArray(new String[props.size()]));
        movimientoRespository.save(movimiento);
    }

    @Override
    public void delete(Integer id) {
        Movimiento movimiento = movimientoRespository.findById(id.longValue()).orElseThrow(MovimientoNotFoundException::new);
        movimientoRespository.delete(movimiento);
    }

    @Override
    public MovimientoDto get(Integer id) {
        return Mappers.getMapper(MovimientoMapper.class)
                .toDto(movimientoRespository.findById(id.longValue())
                        .orElseThrow(MovimientoNotFoundException::new));

    }
}
