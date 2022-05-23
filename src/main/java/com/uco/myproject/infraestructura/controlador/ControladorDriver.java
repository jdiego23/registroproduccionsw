package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoDriver;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.driver.ServicioAplicacionEliminarDriver;
import com.uco.myproject.aplicacion.servicio.driver.ServicioAplicacionGuardarDriver;
import com.uco.myproject.aplicacion.servicio.driver.ServicioAplicacionListarDriver;
import com.uco.myproject.aplicacion.servicio.driver.ServicioAplicacionModificarDriver;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class ControladorDriver {
     private final ServicioAplicacionListarDriver servicioListarDriver;
     private final ServicioAplicacionGuardarDriver servicioGuardarDriver;
     private final ServicioAplicacionEliminarDriver servicioEliminarDriver;
     private final ServicioAplicacionModificarDriver servicioModificarDriver;

    public ControladorDriver(ServicioAplicacionListarDriver servicioListarDriver, ServicioAplicacionGuardarDriver servicioGuardarDriver, ServicioAplicacionEliminarDriver servicioEliminarDriver, ServicioAplicacionModificarDriver servicioModificarDriver) {
        this.servicioListarDriver = servicioListarDriver;
        this.servicioGuardarDriver = servicioGuardarDriver;
        this.servicioEliminarDriver = servicioEliminarDriver;
        this.servicioModificarDriver = servicioModificarDriver;
    }
    @GetMapping
    @SecuredResource(name = "EMPLEADO")
    public List<Driver> listar() {
        return servicioListarDriver.ejecutar();
    }

    @GetMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public Driver listar(@PathVariable Long codigo ) {
        return servicioListarDriver.consultar(codigo);
    }

    @PostMapping
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoDriver dto) {
        return this.servicioGuardarDriver.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoDriver driver, @PathVariable Long codigo)
    {
        return this.servicioModificarDriver.ejecutar(driver,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarDriver.ejecutar(codigo);
    }
}
