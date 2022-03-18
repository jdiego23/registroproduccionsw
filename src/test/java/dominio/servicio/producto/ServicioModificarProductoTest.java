package dominio.servicio.producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.dominio.servicio.producto.ServicioModificarProducto;
import dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioModificarProductoTest {
    @Test
    void verificarNoExistaProducto()
    {
        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio= new ServicioModificarProducto(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Producto con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(producto,1L)).getMessage());
    }
}
