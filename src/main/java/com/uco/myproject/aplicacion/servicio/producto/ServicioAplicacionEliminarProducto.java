package com.uco.myproject.aplicacion.servicio.producto;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.producto.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProducto {
    private final ServicioEliminarProducto servicioEliminarProducto;

    public ServicioAplicacionEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarProducto.ejecutar(codigo));
    }
}
