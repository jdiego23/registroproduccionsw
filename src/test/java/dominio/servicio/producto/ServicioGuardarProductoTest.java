package dominio.servicio.producto;


import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.dominio.servicio.producto.ServicioGuardarProducto;
import dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarProductoTest {
    @Test
    void siProductoYaExisteDeberiaRetornarError() {

        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio = new ServicioGuardarProducto(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Producto con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(producto)
                ).getMessage());

    }

    @Test
    void guardarExitoso() {
        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio = new ServicioGuardarProducto(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Producto.class))).thenReturn(1l);
        var id = servicio.ejecutar(producto);


        Mockito.verify(repositorio, Mockito.times(1)).guardar(producto);
        Assertions.assertEquals(1l, id);

    }
}
