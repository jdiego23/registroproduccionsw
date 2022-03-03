package com.uco.myproject.dominio.modelo;

public class Cliente {

    private final int nit;
    private final String nombre;
    private final String direccion;
    private final String pais;

    public static Cliente of(int nit, String nombre, String direccion, String pais) {

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
