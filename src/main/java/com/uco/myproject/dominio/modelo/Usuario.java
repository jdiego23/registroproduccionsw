package com.uco.myproject.dominio.modelo;

public class Usuario {

    private final String nombre;
    private final String apellido;
    private final String cargo;
    private final String contrasena;

    public static Usuario of(String nombre, String apellido ,String cargo, String contrasena) {

        validarObligatorio(nombre, "El nombre no puede ser vacio");
        validarObligatorio(apellido, "El apellido no puede ser vacio");
        validarObligatorio(cargo, "El cargo no puede ser vacio");
        validarObligatorio(contrasena, "La contraseña no puede estar vacia");


        return new Usuario(nombre, apellido, cargo, contrasena);
    }

    private Usuario(String nombre, String apellido, String cargo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }

    private static void validarObligatorio(String valor, String mensaje) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
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
