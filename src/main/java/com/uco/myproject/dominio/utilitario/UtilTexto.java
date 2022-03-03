package com.uco.myproject.dominio.utilitario;

public class UtilTexto {

    private static final String PATRON_CONTRASENA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9]).{8,}$";


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
        if(cadenaAceptePatron(string, PATRON_CONTRASENA) == false)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
