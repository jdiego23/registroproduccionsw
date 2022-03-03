package com.uco.myproject.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void validarCreacionExitosa() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "juan";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";

        //act (ejecuta el metodo a probar)
        Usuario usuario = Usuario.of(nombre, apellido,cargo,contrasena);

        //assert se valida el resultado

        Assertions.assertEquals("juan", usuario.getNombre());
        Assertions.assertEquals("valencia", usuario.getApellido());
    }

    @Test
    void validarCamposFaltantes() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = null;
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";

        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
            Usuario.of(nombre, apellido, cargo,contrasena)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "";
        String apellido = "valencia";
        String cargo = "operario";
        String contrasena = "asdfghjkl";

        //act - assert (ejecuta el metodo a probar)

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
}
