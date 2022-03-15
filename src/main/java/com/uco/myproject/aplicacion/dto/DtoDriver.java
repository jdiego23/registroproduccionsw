package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoDriver {
    private int Codigo;
    private String descripcion;

    public DtoDriver() {}

    public DtoDriver(int codigo, String descripcion) {
        Codigo = codigo;
        this.descripcion = descripcion;
    }
}
