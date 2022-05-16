package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto, Long codigo) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Usuario usuario = Usuario.of( dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena(),roles);

        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutar(usuario, codigo));
    }
}
