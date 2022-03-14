package com.uco.myproject.dominio.dto;

import lombok.Getter;

@Getter
public class DtoUsuarioResumen {
    private String nombre;
    private String apellido;
    private String cargo;

    public DtoUsuarioResumen() {
    }

    public DtoUsuarioResumen(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }
}
