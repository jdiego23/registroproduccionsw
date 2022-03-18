package dominio.servicio.pedido;

import com.uco.myproject.dominio.puerto.RepositorioPedido;
import com.uco.myproject.dominio.servicio.pedido.ServicioModificarPedido;
import dominio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioModificarPedidoTest {
    @Test
    void verificarNoExistaProducto()
    {
        var pedido = new PedidoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioPedido.class);
        var servicio= new ServicioModificarPedido(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Pedido con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(pedido,1L)).getMessage());
    }
}
