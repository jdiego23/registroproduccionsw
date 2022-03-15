package dominio.modelo;

import com.uco.myproject.dominio.modelo.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DriverTest {

    @Test
    void validarCreacionExitosa() {

        int codigo = 1234;
        String descripcion = "Driver Modelo 1";


        Driver driver = Driver.of(codigo, descripcion);

        Assertions.assertEquals(1234, driver.getCodigo());
        Assertions.assertEquals("Driver Modelo 1", driver.getDescripcion());
    }
    @Test
    void validarCamposObligarotios()
    {
        int codigo = 0;
        String descripcion = "Driver Modelo 1";


        Assertions.assertEquals("El codigo del driver no puede ser Cero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Driver.of(codigo, descripcion)
        ).getMessage());
    }
}
