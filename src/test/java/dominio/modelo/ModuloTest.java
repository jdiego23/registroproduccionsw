package dominio.modelo;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModuloTest {
    @Test
    void validarCreacionExitosa() {

        int codigo = 1234;
        String descripcion = "Modulo Modelo 1";


        Modulo modulo = Modulo.of(codigo, descripcion);

        Assertions.assertEquals(1234, modulo.getCodigo());
        Assertions.assertEquals("Modulo Modelo 1", modulo.getDescripcion());
    }
    @Test
    void validarCamposObligarotios()
    {
        int codigo = 0;
        String descripcion = "Modelo Modelo 1";


        Assertions.assertEquals("El codigo del componente modulo no puede ser cero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Modulo.of(codigo, descripcion)
        ).getMessage());
    }
    @Test
    void validarCamposVacios() {
        int codigo = 1234;
        String descripcion = "";

        Assertions.assertEquals("La descipcion del componete modulo no puede estar vacia",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Modulo.of(codigo, descripcion)
        ).getMessage());
    }
}
