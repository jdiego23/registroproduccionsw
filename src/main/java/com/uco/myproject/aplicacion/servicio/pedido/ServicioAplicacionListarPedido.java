package com.uco.myproject.aplicacion.servicio.pedido;

import com.uco.myproject.dominio.modelo.Pedido;
import com.uco.myproject.dominio.puerto.RepositorioPedido;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarPedido {
    private final RepositorioPedido repositorioPedido;

    public ServicioAplicacionListarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public List<Pedido> ejecutar() {
        return this.repositorioPedido.listar();
    }

    public Pedido consultar(Long id) {return this.repositorioPedido.consultarPorId(id);}
}
