package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoUsuario;

public class DtoPersonaTestDataBuilder {

    private String nombre;
    private String apellido;
    private String cargo;
    private String contrasena;

    public DtoPersonaTestDataBuilder() {
        this.nombre = "juan";
        this.apellido = "valencia";
        this.cargo = "operario";
        this.contrasena = "Asdfghjks1234";
    }

    public DtoPersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoPersonaTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public DtoPersonaTestDataBuilder conCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public DtoPersonaTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public DtoUsuario build() {
        return new DtoUsuario(nombre, apellido, cargo, contrasena);
    }
}
