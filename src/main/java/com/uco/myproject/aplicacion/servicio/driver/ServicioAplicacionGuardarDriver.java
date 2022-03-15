package com.uco.myproject.aplicacion.servicio.driver;

import com.uco.myproject.aplicacion.dto.DtoDriver;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.servicio.driver.ServicioGuardarDriver;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarDriver {
    private final ServicioGuardarDriver servicioGuardarDriver;

    public ServicioAplicacionGuardarDriver(ServicioGuardarDriver servicioGuardarDriver) {
        this.servicioGuardarDriver = servicioGuardarDriver;
    }

    public DtoRespuesta<Long> ejecutar(DtoDriver dto) {

        Driver driver = Driver.of(dto.getCodigo(), dto.getDescripcion());
        return new DtoRespuesta<>(this.servicioGuardarDriver.ejecutar(driver));
    }
}
