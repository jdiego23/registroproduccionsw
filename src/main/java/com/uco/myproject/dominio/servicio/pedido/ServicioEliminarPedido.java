package com.uco.myproject.dominio.servicio.pedido;

import com.uco.myproject.dominio.puerto.RepositorioPedido;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarPedido {
    private static final String MENSAJE_NO_EXISTE = "No existe el pedido con los datos ingresados";

    private final RepositorioPedido repositorioPedido;

    public ServicioEliminarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Long id)
    {
        if(this.repositorioPedido.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return repositorioPedido.eliminar(id);
    }
}
