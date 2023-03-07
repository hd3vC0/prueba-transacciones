package com.trevnu.transacciones.services;

import com.trevnu.transacciones.dto.ClienteDto;
import com.trevnu.transacciones.entity.Cliente;
import com.trevnu.transacciones.exceptions.ClienteNotFoundException;
import com.trevnu.transacciones.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void get_cliente_existe_ok(){
        when(clienteRepository.findById(1)).thenReturn(Optional.of(Cliente.builder()
                        .id(1L)
                        .contrasena("helloworld")
                        .estado(true)
                        .build()
        ));

        ClienteDto clienteDto = clienteService.get(1);

        assertNotNull("Cliente existe", clienteDto);
    }

    @Test
    public void get_cliente_no_existe(){
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class,() -> {
            ClienteDto clienteDto = clienteService.get(2);
        });



    }

}
