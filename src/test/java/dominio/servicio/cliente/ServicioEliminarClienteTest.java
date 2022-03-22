package dominio.servicio.cliente;

import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.dominio.servicio.cliente.ServicioEliminarCliente;
import dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioEliminarClienteTest {
    @Test
    void verificarNoExistaProducto()
    {
        var cliente = new ClienteTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCliente.class);
        var servicio = new ServicioEliminarCliente(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Cliente con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
