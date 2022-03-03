package com.uco.myproject.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ClienteTest {

    @Test
    void validarCreacionExitosa() {

        int nit = 123456;
        String nombre= "UCO";
        String  direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        String pais = "Colombia";

        Cliente cliente = Cliente.of(nit,nombre,direccion,pais);

        Assertions.assertEquals(123456, cliente.getNit());
        Assertions.assertEquals("UCO", cliente.getNombre());
        Assertions.assertEquals("Cra. 46 # 40B-50, Rionegro, Antioquia", cliente.getDireccion());
        Assertions.assertEquals("Colombia", cliente.getPais());
    }

    @Test
    void validarCamposFaltantes() {

        int nit = 123456;
        String nombre= null;
        String  direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        String pais = "Colombia";

        Assertions.assertEquals("EL nombre del cliente no puede estar vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Cliente.of(nit,nombre, direccion,pais)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        int nit = 123456;
        String nombre= "UCO";
        String  direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        String pais = "";

        Assertions.assertEquals("El pais de origen del cliente no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Cliente.of(nit, nombre,direccion,pais)
        ).getMessage());
    }
    @Test
    void validarNitDiferenteCero() {

        int nit = 0;
        String nombre= "UCO";
        String  direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        String pais = "Colombia";

        Assertions.assertEquals("El nit no puede ser Cero",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Cliente.of(nit, nombre,direccion,pais)
        ).getMessage());
    }


}
