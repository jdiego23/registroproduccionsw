package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;
import com.uco.myproject.dominio.utilitario.UtilTexto;

public class Cliente {

    private final int nit;
    private final String nombre;
    private final String direccion;
    private final String pais;

    public static Cliente of(int nit, String nombre, String direccion, String pais) {

        UtilNumero.numeroDiferenteCero(nit, "El nit no puede ser Cero");
        UtilTexto.validarObligatorio(nombre, "EL nombre del cliente no puede estar vacio");
        UtilTexto.validarObligatorio(direccion ,"La direccion del cliente no puede ser vacia");
        UtilTexto.validarObligatorio(pais, "El pais de origen del cliente no puede ser vacio");

        return new Cliente(nit,nombre,direccion, pais);
    }

    private Cliente(int nit, String nombre, String direccion, String pais) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
    }

    public int getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPais() {
        return pais;
    }
}
