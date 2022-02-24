package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoUsuario;

public class DtoPersonaTestDataBuilder {

    private String nombre;
    private String apellido;

    public DtoPersonaTestDataBuilder() {
        this.nombre = "juan";
        this.apellido = "castaño";
    }

    public DtoPersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoPersonaTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public DtoUsuario build() {
        return new DtoUsuario(nombre, apellido);
    }
}
