package com.uco.myproject.dominio.utilitario;

import java.util.List;

public class UtilTexto {

    private static final String PATRON_CONTRASENA = "^(?=.*[a-z])(?=.*?[0-9]).{8,}$";

    public static void validarObligatorio(String valor, String mensaje) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validarLongitudContrasena(String valor, String mensaje)
    {
        if(valor.length()<=8)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static String aplicarTrim(String string)
    {
        return string.trim();
    }

    public static boolean cadenaAceptePatron(String string, String patron)
    {
        return aplicarTrim(string).matches(patron);
    }

    public static void caracteresEspecialesClave(String string, String mensaje)
    {
        if(!cadenaAceptePatron(string, PATRON_CONTRASENA))
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
    public static void validarNoVacia(List<? extends Object> lista, String mensaje) {
        if(lista == null  || lista.isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
