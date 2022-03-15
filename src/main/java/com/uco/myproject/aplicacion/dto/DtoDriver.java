package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoDriver {
    private int codigo;
    private String descripcion;

    public DtoDriver() {}

    public DtoDriver(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
