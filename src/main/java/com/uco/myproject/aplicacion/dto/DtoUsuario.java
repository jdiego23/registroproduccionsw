package com.uco.myproject.aplicacion.dto;

public class DtoUsuario {

    private String nombre;
    private String apellido;
    private String cargo;
    private String contrasena;

    public DtoUsuario() {}

    public DtoUsuario(String nombre, String apellido, String cargo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }
}
