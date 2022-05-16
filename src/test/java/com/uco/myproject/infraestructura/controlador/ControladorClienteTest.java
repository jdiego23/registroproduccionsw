package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoCliente;
import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoClienteTestDataBuilder;
import com.uco.myproject.infraestructura.testdatabuilder.DtoLoginTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
 class ControladorClienteTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioCliente repositorioCliente;

    @Test
    @DisplayName("Debe crear un cliente de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoClienteTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.
                        post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("Debe crear un cliente de forma exitosa y validar que si quedó guardada")
    void crearTest() throws Exception {

        var dto = new DtoClienteTestDataBuilder().build();

        String token = obtenerToken();
        crear(dto, token);
    }

    private void crear(DtoCliente dto, String token) throws Exception {

        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                                .header("Authorization",token)
                )
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var cliente = repositorioCliente.consultarPorId(id);

        Assertions.assertEquals(dto.getNombre(), cliente.getNombre());
        Assertions.assertEquals(dto.getDireccion(), cliente.getDireccion());
        Assertions.assertEquals(dto.getPais(), cliente.getPais());
    }

    @Test
    @DisplayName("Debe listar los clientes luego de crearlas")
    void listarTest() throws Exception {

        var dto = new DtoClienteTestDataBuilder().build();

        String token = obtenerToken();
        this.crear(dto, token);

        mocMvc.perform(get("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is(dto.getNombre())))
                .andExpect(jsonPath("$[0].pais", is(dto.getPais())))
                .andExpect(jsonPath("$[0].direccion", is(dto.getDireccion())));
    }

    private String obtenerToken() throws Exception {
        DtoLogin login = new DtoLoginTestDataBuilder().build();
        var resultLogin = mocMvc.perform(MockMvcRequestBuilders.post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login))
                )
                .andExpect(status().isOk())
                .andReturn();

        return (String) objectMapper.readValue(resultLogin.getResponse().getContentAsString(), DtoRespuesta.class).getValor();
    }
}
