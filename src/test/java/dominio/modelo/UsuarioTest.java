package dominio.modelo;

import com.uco.myproject.dominio.modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void validarCreacionExitosa() {

        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "Asdfghjkl1";


        Usuario usuario = Usuario.of(nombre, apellido,cargo,contrasena);


        Assertions.assertEquals("juan", usuario.getNombre());
        Assertions.assertEquals("valencia", usuario.getApellido());
    }

    @Test
    void validarCamposFaltantes() {

        String nombre = null;
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";


        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
            Usuario.of(nombre, apellido, cargo,contrasena)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        String nombre = "";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena)
        ).getMessage());
    }
    @Test
    void validarLongitudContrasena()
    {
        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdf";

        Assertions.assertEquals("La contraseña debe tener como minimo 8 caracteres y maximo 16 caracteres",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena)
        ).getMessage());
    }
    @Test
    void validarCaracteresEspeciales()
    {
        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfasdfg";

        Assertions.assertEquals("La contrasena debe tener minimo una mayuscula y un numero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena)
        ).getMessage());

    }
}
