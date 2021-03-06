package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoModulo;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.modulo.ServicioAplicacionEliminarModulo;
import com.uco.myproject.aplicacion.servicio.modulo.ServicioAplicacionGuardarModulo;
import com.uco.myproject.aplicacion.servicio.modulo.ServicioAplicacionListarModulo;
import com.uco.myproject.aplicacion.servicio.modulo.ServicioAplicacionModificarModulo;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/modulo")
public class ControladorModulo {
    private final ServicioAplicacionListarModulo servicioListarModulo;
    private final ServicioAplicacionGuardarModulo servicioGuardarModulo;
    private final ServicioAplicacionEliminarModulo servicioEliminarModulo;
    private final ServicioAplicacionModificarModulo servicioModificarModulo;

    public ControladorModulo(ServicioAplicacionListarModulo servicioListarModulo, ServicioAplicacionGuardarModulo servicioGuardarModulo, ServicioAplicacionEliminarModulo servicioEliminarModulo, ServicioAplicacionModificarModulo servicioModificarModulo) {
        this.servicioListarModulo = servicioListarModulo;
        this.servicioGuardarModulo = servicioGuardarModulo;
        this.servicioEliminarModulo = servicioEliminarModulo;
        this.servicioModificarModulo = servicioModificarModulo;
    }

    @GetMapping
    @SecuredResource(name = "EMPLEADO")
    public List<Modulo> listar() {
        return servicioListarModulo.ejecutar();
    }

    @GetMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public Modulo listar(@PathVariable Long codigo ) {
        return servicioListarModulo.consultar(codigo);
    }

    @PostMapping
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoModulo dto) {
        return this.servicioGuardarModulo.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoModulo modulo, @PathVariable Long codigo)
    {
        return this.servicioModificarModulo.ejecutar(modulo,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarModulo.ejecutar(codigo);
    }
}
