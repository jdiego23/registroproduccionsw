package dominio.servicio.driver;

import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.dominio.servicio.driver.ServicioModificarDriver;
import dominio.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioModificarDriverTest {
    @Test
    void verificarNoExistaProducto()
    {
        var driver = new DriverTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioDriver.class);
        var servicio = new ServicioModificarDriver(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Componente Driver que se desea modificar", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(driver,1L)).getMessage());
    }
}
