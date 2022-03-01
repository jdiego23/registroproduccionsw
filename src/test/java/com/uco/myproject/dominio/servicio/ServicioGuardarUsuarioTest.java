package com.uco.myproject.dominio.servicio;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarUsuarioTest {

    /*@Test
    void siNombreYaExisteDeberiaRetornarError() {

        //arrange
        var persona = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe la persona con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
            servicio.ejecutar(persona)
        ).getMessage());

    }

    @Test
    void guardarExitoso() {

        // arrange
        var persona = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Usuario.class))).thenReturn(1l);

        // act
        var id = servicio.ejecutar(persona);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(persona);
        Assertions.assertEquals(1l, id);

    }*/
}
