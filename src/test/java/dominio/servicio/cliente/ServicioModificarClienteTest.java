package dominio.servicio.cliente;

import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.dominio.servicio.cliente.ServicioModificarCliente;
import dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioModificarClienteTest {
    @Test
    void verificarNoExistaProducto()
    {
        var cliente = new ClienteTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCliente.class);
        var servicio = new ServicioModificarCliente(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Cliente con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(cliente,1L)).getMessage());
    }
}
