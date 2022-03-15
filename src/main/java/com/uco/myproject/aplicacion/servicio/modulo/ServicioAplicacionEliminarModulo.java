package com.uco.myproject.aplicacion.servicio.modulo;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.modulo.ServicioEliminarModulo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarModulo {

    private final ServicioEliminarModulo servicioEliminarModulo;

    public ServicioAplicacionEliminarModulo(ServicioEliminarModulo servicioEliminarModulo) {
        this.servicioEliminarModulo = servicioEliminarModulo;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarModulo.ejecutar(codigo));
    }
}
