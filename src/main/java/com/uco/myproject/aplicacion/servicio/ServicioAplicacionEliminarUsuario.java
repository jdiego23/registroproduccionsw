package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.ServicioEliminarUsuario;

public class ServicioAplicacionEliminarUsuario {


    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarUsuario.ejecutar(codigo));
    }

}
