package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoDriver;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoDriverTestDataBuilder;
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
 class ControladorDriverTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioDriver repositorioDriver;

    @Test
    @DisplayName("Debe crear un  de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        var dto = new DtoDriverTestDataBuilder().build();

        crear(dto);

        mocMvc.perform(MockMvcRequestBuilders.
                        post("/api/driver")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("Debe crear un componente driver de forma exitosa y validar que si quedó guardada")
    void crearTest() throws Exception {

        var dto = new DtoDriverTestDataBuilder().build();

        crear(dto);
    }

    private void crear(DtoDriver dto) throws Exception {

        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/driver")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var driver = repositorioDriver.consultarPorId(id);

        Assertions.assertEquals(dto.getCodigo(), driver.getCodigo());
        Assertions.assertEquals(dto.getDescripcion(), driver.getDescripcion());

    }

    @Test
    @DisplayName("Debe listar los componentes driver luego de crearlas")
    void listarTest() throws Exception {

        var dto = new DtoDriverTestDataBuilder().build();

        this.crear(dto);

        mocMvc.perform(get("/api/driver")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codigo", is(dto.getCodigo())))
                .andExpect(jsonPath("$[0].descripcion", is(dto.getDescripcion())));
    }
}
