package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoLoginTestDataBuilder;
import com.uco.myproject.infraestructura.testdatabuilder.DtoUsuarioTestDataBuilder;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorUsuarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Test
    @DisplayName("Debe crear un usuario de forma exitosa y luego fallar al crear la misma")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoUsuarioTestDataBuilder().build();

        String token = obtenerToken();
        crear(dto, token);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }


    @Test
    @DisplayName("Debe crear un usuario de forma exitosa y validar que si quedó guardada")
    void crearTest() throws Exception {

        var dto = new DtoUsuarioTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);
    }

    private void crear(DtoUsuario dto, String token) throws Exception {
        // arrange

        // act
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andReturn();

        //assert
        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var usuario = repositorioUsuario.consultarPorId(id);

        Assertions.assertEquals(dto.getNombre(), usuario.getNombre());
        Assertions.assertEquals(dto.getApellido(), usuario.getApellido());
        Assertions.assertEquals(dto.getCargo(), usuario.getCargo());

    }

    @Test
    @DisplayName("Debe listar los usuarios luego de crearlas")
    void listarTest() throws Exception {

        var dto = new DtoUsuarioTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto,token);

        mocMvc.perform(get("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].apellido", is(dto.getApellido())))
                .andExpect(jsonPath("$[0].cargo", is(dto.getCargo())));
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
