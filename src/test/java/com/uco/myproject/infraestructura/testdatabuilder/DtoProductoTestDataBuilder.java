package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoDriver;
import com.uco.myproject.aplicacion.dto.DtoModulo;
import com.uco.myproject.aplicacion.dto.DtoProducto;


public class DtoProductoTestDataBuilder {
    private int codigo;
    private String nombre;
    private String descripcion;
    private DtoModulo modulo;
    private DtoDriver driver;

    public DtoProductoTestDataBuilder() {
        this.codigo = 1234;
        this.nombre = "producto 1";
        this.descripcion = "primer producto";
        this.modulo = new DtoModulo(1234,"Modulo 1");
        this.driver = new DtoDriver(1234,"Driver 1");
    }

    public DtoProductoTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }
    public DtoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoProductoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DtoProductoTestDataBuilder conModulo(DtoModulo modulo) {
        this.modulo = modulo;
        return this;
    }

    public DtoProductoTestDataBuilder conDriver(DtoDriver driver) {
        this.driver = driver;
        return this;
    }


    public DtoProducto build() {
        return new DtoProducto(codigo,nombre,descripcion,modulo,driver);
    }
}
