package com.uco.myproject.aplicacion.servicio.driver;

import com.uco.myproject.aplicacion.dto.DtoDriver;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.servicio.driver.ServicioModificarDriver;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarDriver {
    private final ServicioModificarDriver servicioModificarDriver;

    public ServicioAplicacionModificarDriver(ServicioModificarDriver servicioModificarDriver) {
        this.servicioModificarDriver = servicioModificarDriver;
    }

    public DtoRespuesta<Long> ejecutar(DtoDriver dto, Long codigo) {

        Driver driver = Driver.of(dto.getCodigo(), dto.getDescripcion());

        return new DtoRespuesta<>(this.servicioModificarDriver.ejecutar(driver, codigo));
    }
}
