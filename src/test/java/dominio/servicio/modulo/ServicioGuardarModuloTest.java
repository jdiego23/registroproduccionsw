package dominio.servicio.modulo;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.dominio.puerto.RepositorioModulo;
import com.uco.myproject.dominio.servicio.driver.ServicioGuardarDriver;
import com.uco.myproject.dominio.servicio.modulo.ServicioGuardarModulo;
import dominio.testdatabuilder.DriverTestDataBuilder;
import dominio.testdatabuilder.ModuloTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarModuloTest {
    @Test
    void siDriverYaExisteDeberiaRetornarError() {

        var modulo = new ModuloTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioModulo.class);
        var servicio = new ServicioGuardarModulo(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("El componente modulo ya existe",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(modulo)
                ).getMessage());

    }

    @Test
    void guardarExitoso() {
        var modulo = new ModuloTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioModulo.class);
        var servicio = new ServicioGuardarModulo(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Modulo.class))).thenReturn(1l);
        var id = servicio.ejecutar(modulo);


        Mockito.verify(repositorio, Mockito.times(1)).guardar(modulo);
        Assertions.assertEquals(1l, id);

    }
}
