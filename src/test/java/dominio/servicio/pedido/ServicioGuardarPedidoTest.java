package dominio.servicio.pedido;

import com.uco.myproject.dominio.modelo.Pedido;
import com.uco.myproject.dominio.puerto.RepositorioPedido;
import com.uco.myproject.dominio.servicio.pedido.ServicioGuardarPedido;
import dominio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioGuardarPedidoTest {
        @Test
        void siProductoYaExisteDeberiaRetornarError()
        {

            var pedido = new PedidoTestDataBuilder().build();

            var repositorio = Mockito.mock(RepositorioPedido.class);
            var servicio = new ServicioGuardarPedido(repositorio);

            Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

            Assertions.assertEquals("Ya existe el Pedido con los datos ingresados",
                    Assertions.assertThrows(IllegalStateException.class, () ->
                            servicio.ejecutar(pedido)
                    ).getMessage());

        }

        @Test
        void guardarExitoso() {
            var pedido = new PedidoTestDataBuilder().build();

            var repositorio = Mockito.mock(RepositorioPedido.class);
            var servicio = new ServicioGuardarPedido(repositorio);


           Mockito.when(repositorio.guardar(Mockito.any(Pedido.class))).thenReturn(1l);
           var id = servicio.ejecutar(pedido);


           Mockito.verify(repositorio, Mockito.times(1)).guardar(pedido);
           Assertions.assertEquals(1l, id);

        }
}
