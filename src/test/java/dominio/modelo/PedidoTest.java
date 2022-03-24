package dominio.modelo;

import com.uco.myproject.dominio.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PedidoTest {
        @Test
        void validarCreacionExitosa() {
            int numero = 1234;
            Cliente cliente;
            Producto producto;
            int cantidad = 4;
            cliente = Cliente.of(1234,"uco","Cra. 46 # 40B-50, Rionegro, Antioquia","Colombia");
            Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
            Driver driver = Driver.of(1234, "Driver prueba producto");
            producto = Producto.of(1234, "Producto 1", "primer producto prueba unitaria", modulo, driver);


             Pedido pedido = Pedido.of(numero,cliente,producto,cantidad);



             Assertions.assertEquals(1234, pedido.getNumero());
             Assertions.assertEquals(4,pedido.getCantidad());
            Assertions.assertEquals("Producto 1",pedido.getProducto().getNombre());
            Assertions.assertEquals("uco",pedido.getCliente().getNombre());
            Assertions.assertEquals("Modulo prueba producto",pedido.getProducto().getModulo().getDescripcion());

        }

        @Test
        void validarCamposFaltantes() {
            int numero = 0;
            Cliente cliente;
            Producto producto;
            int cantidad = 4;
            cliente = Cliente.of(1234,"uco","Cra. 46 # 40B-50, Rionegro, Antioquia","Colombia");
            Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
            Driver driver = Driver.of(1234, "Driver prueba producto");
            producto = Producto.of(1234, "Producto 1", "primer producto prueba unitaria", modulo, driver);


         Assertions.assertEquals("El numero del pedido no puede ser cero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                 Pedido.of(numero,cliente,producto,cantidad)
         ).getMessage());
        }
    @Test
    void validarCantidadNegativa() {
        int numero = 1;
        Cliente cliente;
        Producto producto;
        int cantidad = -3;
        cliente = Cliente.of(1234,"uco","Cra. 46 # 40B-50, Rionegro, Antioquia","Colombia");
        Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
        Driver driver = Driver.of(1234, "Driver prueba producto");
        producto = Producto.of(1234, "Producto 1", "primer producto prueba unitaria", modulo, driver);


        Assertions.assertEquals("La cantidad del pedido no puede ser negativa",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Pedido.of(numero,cliente,producto,cantidad)
        ).getMessage());
    }

}
