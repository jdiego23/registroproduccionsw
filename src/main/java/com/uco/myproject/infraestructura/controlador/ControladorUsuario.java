package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.servicio.ServicioAplicacionEliminarUsuario;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionGuardarUsuario;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionListarUsuario;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionModificarUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorUsuario {

    private final ServicioAplicacionListarUsuario servicioListarUsuario;
    private final ServicioAplicacionGuardarUsuario servicioGuardarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioEliminarUsuario;
    private final ServicioAplicacionModificarUsuario servicioModificarUsuario;


    public ControladorUsuario(ServicioAplicacionListarUsuario servicioListarUsuario, ServicioAplicacionGuardarUsuario servicioGuardarUsuario, ServicioAplicacionEliminarUsuario servicioEliminarUsuario, ServicioAplicacionModificarUsuario servicioModificarUsuario) {
        this.servicioListarUsuario = servicioListarUsuario;
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioEliminarUsuario = servicioEliminarUsuario;
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    @GetMapping
    public List<Usuario> listar() {
        return servicioListarUsuario.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        return this.servicioGuardarUsuario.ejecutar(dto);
    }
}
