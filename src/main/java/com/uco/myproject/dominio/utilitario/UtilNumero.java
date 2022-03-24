package com.uco.myproject.dominio.utilitario;

public class UtilNumero {

    public static void numeroDiferenteCero(int numero,String mensaje)
    {
        if(numero==0)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
    public static void numeroNoPuedeSerNegativo(int numero,String mensaje)
    {
        if(numero < 0)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

}
