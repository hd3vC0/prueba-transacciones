package com.trevnu.transacciones.services;

import com.trevnu.transacciones.dto.ClienteDto;
import com.trevnu.transacciones.entity.Cliente;
import com.trevnu.transacciones.exceptions.ClienteNotFoundException;
import com.trevnu.transacciones.mappers.ClienteMapper;
import com.trevnu.transacciones.repositories.ClienteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public void create(ClienteDto dto) {
        clienteRepository.save(Mappers.getMapper(ClienteMapper.class).toEntity(dto));
    }

    @Override
    public List<ClienteDto> getAll() {
        List<Cliente> list = new ArrayList<>();
        clienteRepository.findAll().forEach(list::add);
        return list.stream().map(x -> Mappers.getMapper(ClienteMapper.class).toDto(x)).toList();
    }

    @Override
    public void update(Integer id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
        BeanWrapper wrapper = new BeanWrapperImpl(dto);
        List<String> props = Arrays.stream(wrapper.getPropertyDescriptors())
                .filter(x -> wrapper.getPropertyValue(x.getName()) == null)
                .map(x -> x.getName()).toList();


        BeanUtils.copyProperties(dto, cliente, props.toArray(new String[props.size()]));
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
        clienteRepository.delete(cliente);
    }

    @Override
    public ClienteDto get(Integer id) {
        Optional<ClienteDto> clienteDto = clienteRepository.findById(id).map(x -> Mappers.getMapper(ClienteMapper.class).toDto(x));
        return clienteDto.orElseThrow(ClienteNotFoundException::new);
    }
}
