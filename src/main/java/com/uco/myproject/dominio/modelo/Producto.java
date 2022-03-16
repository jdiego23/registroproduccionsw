package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;
import com.uco.myproject.dominio.utilitario.UtilTexto;

public class Producto {
    private final int codigo;
    private final String nombre;
    private final String descripcion;
    private final Modulo modulo;
    private final Driver driver;

    public static Producto of(int codigo, String nombre, String descripcion,Modulo modulo,Driver driver) {
        UtilNumero.numeroDiferenteCero(codigo,"El codigo del producto no puede ser cero");
        UtilTexto.validarObligatorio(nombre, "El nombre del producto no puede estar vacio");
        UtilTexto.validarObligatorio(descripcion,"La descripcion del producto no puede estar vacio");
        return new Producto(codigo,nombre,descripcion, modulo, driver);
    }

    private Producto(int codigo, String nombre, String descripcion, Modulo modulo, Driver driver) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modulo = modulo;
        this.driver = driver;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public Driver getDriver() {
        return driver;
    }
}
