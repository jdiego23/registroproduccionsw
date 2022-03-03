package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.servicio.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto, Long codigo) {

        Usuario usuario = Usuario.of( dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena());

        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutar(usuario, codigo));
    }

}
