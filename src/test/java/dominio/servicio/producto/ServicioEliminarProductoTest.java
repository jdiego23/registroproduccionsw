package dominio.servicio.producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.dominio.servicio.producto.ServicioEliminarProducto;
import dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioEliminarProductoTest {
    @Test
    void verificarNoExistaProducto()
    {
        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio= new ServicioEliminarProducto(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el producto con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
