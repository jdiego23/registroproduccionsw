package com.uco.myproject.dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Usuario;

public class UsuarioTestDataBuilder {

    private String nombre;
    private String apellido;
    private String cargo = "operario";
    private String contrasena = "asdfghjkl";

    public UsuarioTestDataBuilder() {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public UsuarioTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }


    public Usuario build() {
        return Usuario.of(nombre, apellido, cargo, contrasena);
    }
}
