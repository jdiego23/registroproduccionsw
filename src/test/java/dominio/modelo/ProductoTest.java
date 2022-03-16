package dominio.modelo;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.modelo.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductoTest {
    @Test
    void validarCreacionExitosa() {
        int codigo = 1234;
        String nombre = "Producto 1";
        String descripcion = "primer producto prueba unitaria";
        Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
        Driver driver = Driver.of(1234, "Driver prueba producto");
        Producto producto = Producto.of(codigo, nombre, descripcion, modulo, driver);

        Assertions.assertEquals(1234, producto.getCodigo());
        Assertions.assertEquals("Producto 1", producto.getNombre());
        Assertions.assertEquals("primer producto prueba unitaria", producto.getDescripcion());
        Assertions.assertEquals(1234, producto.getModulo().getCodigo());
        Assertions.assertEquals(1234, producto.getDriver().getCodigo());
    }

  @Test
    void validarCamposFaltantes() {

      int codigo = 0;
      String nombre = "Producto 1";
      String descripcion = "primer producto prueba unitaria";
      Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
      Driver driver = Driver.of(1234, "Driver prueba producto");


        Assertions.assertEquals("El codigo del producto no puede ser cero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                 Producto.of(codigo, nombre, descripcion, modulo, driver)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {
        int codigo = 1234;
        String nombre = "";
        String descripcion = "primer producto prueba unitaria";
        Modulo modulo = Modulo.of(1234, "Modulo prueba producto");
        Driver driver = Driver.of(1234, "Driver prueba producto");

        Assertions.assertEquals("El nombre del producto no puede estar vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Producto.of(codigo, nombre, descripcion, modulo, driver)
        ).getMessage());
    }
 }
