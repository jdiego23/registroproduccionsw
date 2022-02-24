package com.uco.myproject.aplicacion.dto;

public class DtoUsuario {

    private String nombre;
    private String apellido;

    public DtoUsuario() {}

    public DtoUsuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
