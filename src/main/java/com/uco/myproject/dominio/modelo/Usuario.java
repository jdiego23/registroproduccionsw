package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilTexto;

public class Usuario {

    private final String nombre;
    private final String apellido;
    private final String cargo;
    private final String contrasena;

    public static Usuario of(String nombre, String apellido ,String cargo, String contrasena) {

        UtilTexto.validarObligatorio(nombre,"El nombre no puede ser vacio");
        UtilTexto.validarObligatorio(apellido, "El apellido no puede ser vacio");
        UtilTexto.validarObligatorio(cargo, "El cargo no puede ser vacio");
        UtilTexto.validarObligatorio(contrasena, "La contraseña no puede estar vacia");
        UtilTexto.validarLongitudContrasena(contrasena,"La contraseña debe tener como minimo 8 caracteres y maximo 16 caracteres");
        return new Usuario(nombre, apellido, cargo, contrasena);
    }
    private Usuario(String nombre, String apellido, String cargo, String contrasena) {
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
