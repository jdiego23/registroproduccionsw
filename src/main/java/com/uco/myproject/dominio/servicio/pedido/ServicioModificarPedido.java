package com.uco.myproject.dominio.servicio.pedido;

import com.uco.myproject.dominio.modelo.Pedido;
import com.uco.myproject.dominio.puerto.RepositorioPedido;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarPedido {
    private static final String MENSAJE_NO_EXISTE = "No existe el Pedido con los datos ingresados";

    private final RepositorioPedido repositorioPedido;

    public ServicioModificarPedido( RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido, Long codigo) {

        if(this.repositorioPedido.consultarPorId(codigo)== null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioPedido.modificar(pedido,codigo);
    }
}
