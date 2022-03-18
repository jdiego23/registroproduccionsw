package dominio.servicio.pedido;

import com.uco.myproject.dominio.puerto.RepositorioPedido;
import com.uco.myproject.dominio.servicio.pedido.ServicioEliminarPedido;
import dominio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPedidoTest {
     @Test
     void verificarNoExistaProducto()
     {
         var pedido = new PedidoTestDataBuilder().build();

         var repositorio = Mockito.mock(RepositorioPedido.class);
         var servicio = new ServicioEliminarPedido(repositorio);

         Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

         Assertions.assertEquals("No existe el pedido con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(1L)).getMessage());
     }
}
