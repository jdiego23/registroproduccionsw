package com.uco.myproject.aplicacion.servicio.modulo;

import com.uco.myproject.aplicacion.dto.DtoModulo;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.servicio.modulo.ServicioModificarModulo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarModulo {
    private final ServicioModificarModulo servicioModificarModulo;

    public ServicioAplicacionModificarModulo(ServicioModificarModulo servicioModificarModulo) {
        this.servicioModificarModulo = servicioModificarModulo;
    }

    public DtoRespuesta<Long> ejecutar(DtoModulo dto, Long codigo) {

        Modulo modulo = Modulo.of(dto.getCodigo(), dto.getDescripcion());

        return new DtoRespuesta<>(this.servicioModificarModulo.ejecutar(modulo, codigo));
    }
}
