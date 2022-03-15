package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoDriver;

public class DtoDriverTestDataBuilder {
    private int codigo ;
    private String descripcion ;

    public DtoDriverTestDataBuilder() {
        this.codigo = 1234;
        this.descripcion =  "Driver Modelo 1";
    }

    public DtoDriverTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public DtoDriverTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DtoDriver build() {
        return new DtoDriver(codigo, descripcion);
    }
}
