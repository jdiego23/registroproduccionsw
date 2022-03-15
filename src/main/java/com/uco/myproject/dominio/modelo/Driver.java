package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;
import com.uco.myproject.dominio.utilitario.UtilTexto;

public class Driver {

    private final int codigo;
    private final String descripcion;

    public static Driver of(int codigo, String descripcion)
    {
        UtilNumero.numeroDiferenteCero(codigo, "El codigo del driver no puede ser Cero");
        UtilTexto.validarObligatorio(descripcion,"La descripcion del driver no puede ser vacia");
        return new Driver(codigo,descripcion);
    }

    private Driver(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
