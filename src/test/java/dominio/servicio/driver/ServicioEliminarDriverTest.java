package dominio.servicio.driver;

import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.dominio.servicio.driver.ServicioEliminarDriver;
import dominio.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarDriverTest {
    @Test
    void verificarNoExistaProducto()
    {
        var driver = new DriverTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioDriver.class);
        var servicio = new ServicioEliminarDriver(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Componente Driver con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(1L)).getMessage());
    }
}
