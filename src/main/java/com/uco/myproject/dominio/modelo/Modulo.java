package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;
import com.uco.myproject.dominio.utilitario.UtilTexto;

public class Modulo {
    private final  int codigo;
    private  final  String descripcion;

    public static Modulo of(int codigo, String descripcion) {
        UtilNumero.numeroDiferenteCero(codigo,"El codigo del componente modulo no puede ser cero");
        UtilTexto.validarObligatorio(descripcion,"La descipcion del componete modulo no pude estar vacia");
        return new Modulo(codigo, descripcion);
    }

    private Modulo(int codigo, String descripcion) {
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
