package com.uco.myproject.dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Usuario;

public class UsuarioTestDataBuilder {

    private String nombre;
    private String apellido;

    public UsuarioTestDataBuilder() {
        this.nombre = "juan";
        this.apellido = "castano";
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Usuario build() {
        return Usuario.of(nombre, apellido);
    }
}
