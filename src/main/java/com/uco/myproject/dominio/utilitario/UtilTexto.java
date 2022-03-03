package com.uco.myproject.dominio.utilitario;

public class UtilTexto {

    public static void validarObligatorio(String valor, String mensaje) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validarLongitudContrasena(String valor, String mensaje)
    {
        if(valor.length()<=8 || valor.length()>=16)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
