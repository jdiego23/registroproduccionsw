package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.servicio.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto) {

        Usuario usuario = Usuario.of(dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena());

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
