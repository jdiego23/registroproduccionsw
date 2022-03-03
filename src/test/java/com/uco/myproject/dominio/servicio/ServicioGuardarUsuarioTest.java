package com.uco.myproject.dominio.servicio;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.dominio.servicio.usuario.ServicioGuardarUsuario;
import com.uco.myproject.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarUsuarioTest {

    @Test
    void siNombreYaExisteDeberiaRetornarError() {

        //arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el usuario con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
            servicio.ejecutar(usuario)
        ).getMessage());

    }

    @Test
    void guardarExitoso() {

        // arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Usuario.class))).thenReturn(1l);

        // act
        var id = servicio.ejecutar(usuario);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(usuario);
        Assertions.assertEquals(1l, id);

    }
}
