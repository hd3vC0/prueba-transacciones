package com.trevnu.transacciones.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Test
    void crear_cliente_retorna200() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new ClienteController()).build();

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
