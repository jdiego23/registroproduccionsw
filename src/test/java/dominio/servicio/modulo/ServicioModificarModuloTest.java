package dominio.servicio.modulo;


import com.uco.myproject.dominio.puerto.RepositorioModulo;
import com.uco.myproject.dominio.servicio.modulo.ServicioModificarModulo;
import dominio.testdatabuilder.ModuloTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioModificarModuloTest {
    @Test
    void verificarNoExistaProducto()
    {
        var modulo = new ModuloTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioModulo.class);
        var servicio = new ServicioModificarModulo(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Componente modulo que se desea modificar", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(modulo,1L)).getMessage());
    }
}
