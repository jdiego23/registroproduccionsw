package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.utilitario.UtilNumero;

public class Pedido {
    private final int numero;
    private final Cliente cliente;
    private final Producto producto;
    private final int cantidad;

    public static Pedido of(int numero, Cliente cliente, Producto producto, int cantidad) {
        UtilNumero.numeroDiferenteCero(numero,"El numero del pedido no puede ser cero");
        UtilNumero.numeroDiferenteCero(cantidad,"La catidad del del pedido no puede ser cero");
        return new Pedido(numero, cliente, producto, cantidad);
    }

    private Pedido(int numero, Cliente cliente, Producto producto, int cantidad) {
        this.numero = numero;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
