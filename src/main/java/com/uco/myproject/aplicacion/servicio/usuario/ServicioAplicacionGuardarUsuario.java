package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.servicio.ServicioCifrarTexto;
import com.uco.myproject.dominio.servicio.usuario.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Usuario usuario = Usuario.of(dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena(), roles);

        String claveCifrada = this.servicioCifrarTexto.ejecutar(usuario.getContrasena());

        usuario.asignarClaveCifrada(claveCifrada);

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
