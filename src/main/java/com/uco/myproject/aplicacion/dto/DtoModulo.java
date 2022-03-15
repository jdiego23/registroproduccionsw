package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoModulo {
    private int codigo;
    private String descripcion;

    public DtoModulo() {}

    public DtoModulo(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
