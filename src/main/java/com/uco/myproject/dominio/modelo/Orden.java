package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;

public class Orden {
    private final int numero;
    private  final int pedido;

    public static Orden of(int numero, int pedido) {
        UtilNumero.numeroDiferenteCero(numero, "El numero de la orden debe ser diferente de cero");

        return new Orden(numero,pedido);
    }

    public Orden(int numero, int pedido) {
        this.numero = numero;
        this.pedido = pedido;
    }

    public int getNumero() {
        return numero;
    }

    public int getPedido() {
        return pedido;
    }
}
