package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.*;

public class PedidoTestDataBuilder {
    private int numero;
     private Cliente cliente;
     private Producto producto;
     private int cantidad;

     public PedidoTestDataBuilder() {
          this.numero = 1234;
          this.cliente = Cliente.of(123,"uco","calle 20","colombia");
          this.producto = Producto.of(123,"producto","producto pedido",
                  Modulo.of(13,"modulo pedido"), Driver.of(14,"driver pedido"));
          this.cantidad = 4;
     }
     public PedidoTestDataBuilder conNumero(int numero) {
          this.numero = numero;
          return this;
     }
     public PedidoTestDataBuilder conCliente(Cliente cliente) {
          this.cliente = cliente;
          return this;
     }

     public PedidoTestDataBuilder conProducto(Producto producto) {
          this.producto = producto;
          return this;
     }

     public PedidoTestDataBuilder conCantidad(int cantidad) {
          this.cantidad = cantidad;
          return this;
     }
     public Pedido build() {
          return Pedido.of(numero,cliente,producto,cantidad);
     }
}
