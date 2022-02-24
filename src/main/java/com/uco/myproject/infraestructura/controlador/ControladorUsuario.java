package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.servicio.ServicioAplicacionGuardarUsuario;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionListarUsuario;
import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorUsuario {

    private final ServicioAplicacionListarUsuario servicioListarPersonas;
    private final ServicioAplicacionGuardarUsuario servicioGuardarPersona;

    public ControladorUsuario(ServicioAplicacionListarUsuario servicioListarPersonas, ServicioAplicacionGuardarUsuario servicioGuardarPersona) {
        this.servicioListarPersonas = servicioListarPersonas;
        this.servicioGuardarPersona = servicioGuardarPersona;
        //todo 
    }

    @GetMapping
    public List<Usuario> listar() {
        return servicioListarPersonas.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        return this.servicioGuardarPersona.ejecutar(dto);
    }
}
