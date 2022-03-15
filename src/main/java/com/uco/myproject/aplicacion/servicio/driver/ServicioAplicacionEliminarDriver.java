package com.uco.myproject.aplicacion.servicio.driver;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.driver.ServicioEliminarDriver;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarDriver {
    private final ServicioEliminarDriver servicioEliminarDriver;

    public ServicioAplicacionEliminarDriver(ServicioEliminarDriver servicioEliminarDriver) {
        this.servicioEliminarDriver = servicioEliminarDriver;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarDriver.ejecutar(codigo));
    }
}
