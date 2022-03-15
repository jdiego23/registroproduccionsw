package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoCliente {
    private int nit;
    private String nombre;
    private String direccion;
    private String pais;

    public DtoCliente() {}

    public DtoCliente(int nit, String nombre, String direccion, String pais) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
    }
}
