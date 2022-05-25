package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionEliminarUsuario;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionGuardarUsuario;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionListarUsuario;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionModificarUsuario;
import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
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
    @SecuredResource(name = "EMPLEADO")
    public List<DtoUsuarioResumen> listar() {
        return servicioListarUsuario.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoUsuarioResumen listar(@PathVariable Long codigo ) {
        return servicioListarUsuario.consultar(codigo);
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        return this.servicioGuardarUsuario.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoUsuario usuario, @PathVariable Long codigo)
    {
        return this.servicioModificarUsuario.ejecutar(usuario,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarUsuario.ejecutar(codigo);
    }
}
