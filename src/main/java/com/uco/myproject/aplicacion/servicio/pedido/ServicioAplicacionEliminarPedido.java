package com.uco.myproject.aplicacion.servicio.pedido;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.pedido.ServicioEliminarPedido;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPedido {
    private final ServicioEliminarPedido servicioEliminarPedido;

    public ServicioAplicacionEliminarPedido(ServicioEliminarPedido servicioEliminarPedido) {
        this.servicioEliminarPedido = servicioEliminarPedido;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarPedido.ejecutar(codigo));
    }
}
