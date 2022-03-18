package com.uco.myproject.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class EntidadPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numero;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cliente_id")
    private EntidadCliente cliente;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "producto_id")
    private EntidadProducto producto;

    private int cantidad;

    public EntidadPedido() {
    }

    public EntidadPedido(int numero, EntidadCliente cliente, EntidadProducto producto, int cantidad) {

        this.numero = numero;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
