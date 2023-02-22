package com.trevnu.transacciones.services;

import com.trevnu.transacciones.dto.CuentaDto;
import com.trevnu.transacciones.entity.Cliente;
import com.trevnu.transacciones.entity.Cuenta;
import com.trevnu.transacciones.exceptions.ClienteNotFoundException;
import com.trevnu.transacciones.exceptions.CuentaNotFoundException;
import com.trevnu.transacciones.mappers.CuentaMapper;
import com.trevnu.transacciones.repositories.ClienteRepository;
import com.trevnu.transacciones.repositories.CuentaRepository;
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
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public void create(CuentaDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteid()).orElseThrow(ClienteNotFoundException::new);
        Cuenta cuenta = Mappers.getMapper(CuentaMapper.class).toEntity(dto);
        cuenta.setCliente(cliente);
        cuentaRepository.save(cuenta);
    }

    @Override
    public List<CuentaDto> getAll() {
        List<Cuenta> list = new ArrayList<>();
        cuentaRepository.findAll().forEach(list::add);
        CuentaMapper mapper = Mappers.getMapper(CuentaMapper.class);
        return list.stream().map(mapper::toDto).toList();
    }

    @Override
    public void update(Integer id, CuentaDto dto) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(CuentaNotFoundException::new);
        BeanWrapper wrapper = new BeanWrapperImpl(dto);
        List<String> props = Arrays.stream(wrapper.getPropertyDescriptors())
                .filter(x -> wrapper.getPropertyValue(x.getName()) == null)
                .map(x -> x.getName()).toList();
        BeanUtils.copyProperties(dto, cuenta, props.toArray(new String[props.size()]));
        cuentaRepository.save(cuenta);

    }

    @Override
    public void delete(Integer id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(CuentaNotFoundException::new);
        cuentaRepository.deleteById(id);

    }

    @Override
    public CuentaDto get(Integer id) {
        return Mappers.getMapper(CuentaMapper.class).toDto(cuentaRepository.findById(id).orElseThrow(CuentaNotFoundException::new));
    }
}
