package com.uco.myproject.dominio.dto;

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

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }
}
