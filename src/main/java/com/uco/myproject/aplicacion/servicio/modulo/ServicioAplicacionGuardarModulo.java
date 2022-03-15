package com.uco.myproject.aplicacion.servicio.modulo;

import com.uco.myproject.aplicacion.dto.DtoModulo;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.servicio.modulo.ServicioGuardarModulo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarModulo {
    private final ServicioGuardarModulo servicioGuardarModulo;

    public ServicioAplicacionGuardarModulo(ServicioGuardarModulo servicioGuardarModulo) {
        this.servicioGuardarModulo = servicioGuardarModulo;
    }

    public DtoRespuesta<Long> ejecutar(DtoModulo dto) {

        Modulo modulo = Modulo.of(dto.getCodigo(), dto.getDescripcion());
        return new DtoRespuesta<>(this.servicioGuardarModulo.ejecutar(modulo));
    }
}
