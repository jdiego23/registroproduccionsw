package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoProducto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private DtoModulo modulo;
    private DtoDriver driver;

    public DtoProducto() {}

    public DtoProducto(int codigo, String nombre, String descripcion,DtoModulo modulo,DtoDriver driver) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modulo = modulo;
        this.driver = driver;
    }
}
