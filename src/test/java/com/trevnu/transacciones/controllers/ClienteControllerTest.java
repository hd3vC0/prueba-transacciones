package com.trevnu.transacciones.controllers;

import com.trevnu.transacciones.dto.ClienteDto;
import com.trevnu.transacciones.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    ClienteService clienteService;

    @Test
    void crear_cliente_retorna200() throws Exception {
        doNothing().when(clienteService).create(ClienteDto.builder()
                        .nombre("Juan Perez")
                        .genero("Masculino")
                        .edad(22)
                        .identificacion("111111111")
                        .direccion("calle 123")
                        .telefono("55555555")
                        .contrasena("segura")
                .build());
        when(clienteService.getAll()).thenReturn(null);
        mockMvc.perform(
                post("/clientes")
                        .contentType("application/json")
                        .content("{" +
                                "    \"nombre\": \"Juan Perez\"," +
                                "    \"genero\": \"Masculino\"," +
                                "    \"edad\": 22," +
                                "    \"identificacion\": \"111111111\"," +
                                "    \"direccion\": \"calle 123\"," +
                                "    \"telefono\": \"55555555\"," +
                                "    \"contrasena\": \"segura\"" +
                                "}"))
                .andExpect(status().isOk());
    }
}
