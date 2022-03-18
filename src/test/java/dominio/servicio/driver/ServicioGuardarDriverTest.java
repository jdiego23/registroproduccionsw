package dominio.servicio.driver;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.dominio.servicio.driver.ServicioGuardarDriver;
import dominio.testdatabuilder.DriverTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioGuardarDriverTest {
    @Test
    void siDriverYaExisteDeberiaRetornarError() {

        var driver = new DriverTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioDriver.class);
        var servicio = new ServicioGuardarDriver(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("El componente driver ya existe",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(driver)
                ).getMessage());

    }

    @Test
    void guardarExitoso() {

        var driver = new DriverTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioDriver.class);
        var servicio = new ServicioGuardarDriver(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Driver.class))).thenReturn(1l);
        var id = servicio.ejecutar(driver);


        Mockito.verify(repositorio, Mockito.times(1)).guardar(driver);
        Assertions.assertEquals(1l, id);

    }
}
