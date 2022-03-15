package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoModulo;

public class DtoModuloTestDataBuilder {
    private int codigo ;
    private String descripcion ;

    public DtoModuloTestDataBuilder() {
        this.codigo = 1234;
        this.descripcion =  "Modelo Modelo 1";
    }

    public DtoModuloTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public DtoModuloTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DtoModulo build() {return new DtoModulo(codigo, descripcion);}
}
