package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoCliente;


public class DtoClienteTestDataBuilder {

    private int nit;
    private String nombre;
    private String direccion;
    private String pais;

    public DtoClienteTestDataBuilder() {
        this.nit = 12345;
        this.nombre = "Uco";
        this.direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        this.pais = "colombia";
    }
    public DtoClienteTestDataBuilder conNit(int nit) {
        this.nit = nit;
        return this;
    }

    public DtoClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public DtoClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public DtoClienteTestDataBuilder conPais(String pais) {
        this.pais = pais;
        return this;
    }

    public DtoCliente build() {
        return new DtoCliente(nit,nombre, direccion, pais);
    }
}
