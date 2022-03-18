package com.uco.myproject.dominio.servicio.pedido;

import com.uco.myproject.dominio.modelo.Pedido;
import com.uco.myproject.dominio.puerto.RepositorioPedido;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPedido {
    private static final String MENSAJE_YA_EXISTE = "Ya existe el Pedido con los datos ingresados";

    private final RepositorioPedido repositorioPedido;

    public ServicioGuardarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido) {

        if(this.repositorioPedido.existe(pedido)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioPedido.guardar(pedido);
    }
}
