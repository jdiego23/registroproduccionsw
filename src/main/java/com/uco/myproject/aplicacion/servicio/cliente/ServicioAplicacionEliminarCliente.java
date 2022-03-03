package com.uco.myproject.aplicacion.servicio.cliente;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.cliente.ServicioEliminarCliente;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarCliente {
    private final ServicioEliminarCliente servicioEliminarCliente;

    public ServicioAplicacionEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarCliente.ejecutar(codigo));
    }
}
