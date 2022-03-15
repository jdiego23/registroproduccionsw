package dominio.servicio.cliente;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.dominio.servicio.cliente.ServicioGuardarCliente;
import com.uco.myproject.dominio.servicio.usuario.ServicioGuardarUsuario;
import dominio.testdatabuilder.ClienteTestDataBuilder;
import dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarClienteTest {
    @Test
    void siNombreYaExisteDeberiaRetornarError() {

        //arrange
        var cliente = new ClienteTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCliente.class);
        var servicio = new ServicioGuardarCliente(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el Cliente con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(cliente)
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
