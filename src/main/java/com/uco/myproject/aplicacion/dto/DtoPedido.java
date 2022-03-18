package com.uco.myproject.aplicacion.dto;

import lombok.Getter;

@Getter
public class DtoPedido {
    int numero;
    DtoCliente cliente;
    DtoProducto producto;
    int cantidad;

    public DtoPedido() {}

    public DtoPedido(int numero, DtoCliente cliente, DtoProducto producto, int cantidad) {
        this.numero = numero;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
