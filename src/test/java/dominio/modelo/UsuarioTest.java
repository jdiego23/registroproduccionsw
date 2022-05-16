package dominio.modelo;

import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UsuarioTest {

    @Test
    void validarCreacionExitosa() {

        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "Asdfghjkl1";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));


        Usuario usuario = Usuario.of(nombre, apellido,cargo,contrasena,roles);


        Assertions.assertEquals("juan", usuario.getNombre());
        Assertions.assertEquals("valencia", usuario.getApellido());
    }

    @Test
    void validarCamposFaltantes() {

        String nombre = null;
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));


        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
            Usuario.of(nombre, apellido, cargo,contrasena,roles)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        String nombre = "";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena,roles)
        ).getMessage());
    }
    @Test
    void validarLongitudContrasena()
    {
        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdf";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Assertions.assertEquals("La contraseña debe tener como minimo 8 caracteres y maximo 16 caracteres",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena,roles)
        ).getMessage());
    }
    @Test
    void validarCaracteresEspeciales()
    {
        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfasdfg";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Assertions.assertEquals("La contrasena debe tener minimo una mayuscula y un numero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido,cargo, contrasena,roles)
        ).getMessage());

    }
}
