package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoCliente;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.cliente.ServicioAplicacionEliminarCliente;
import com.uco.myproject.aplicacion.servicio.cliente.ServicioAplicacionGuardarCliente;
import com.uco.myproject.aplicacion.servicio.cliente.ServicioAplicacionListarCliente;
import com.uco.myproject.aplicacion.servicio.cliente.ServicioAplicacionModificarCliente;
import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {

    private final ServicioAplicacionListarCliente servicioListarCliente;
    private final ServicioAplicacionGuardarCliente servicioGuardarCliente;
    private final ServicioAplicacionEliminarCliente servicioEliminarCliente;
    private final ServicioAplicacionModificarCliente servicioModificarCliente;

    public ControladorCliente(ServicioAplicacionListarCliente servicioListarCliente, ServicioAplicacionGuardarCliente servicioGuardarCliente, ServicioAplicacionEliminarCliente servicioEliminarCliente, ServicioAplicacionModificarCliente servicioModificarCliente) {
        this.servicioListarCliente = servicioListarCliente;
        this.servicioGuardarCliente = servicioGuardarCliente;
        this.servicioEliminarCliente = servicioEliminarCliente;
        this.servicioModificarCliente = servicioModificarCliente;
    }

    @GetMapping
    @SecuredResource(name = "EMPLEADO")
    public List<Cliente> listar() {
        return servicioListarCliente.ejecutar();
    }

    @GetMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public Cliente listar(@PathVariable Long codigo ) {
        return servicioListarCliente.consultar(codigo);
    }

    @PostMapping
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoCliente dto) {
        return this.servicioGuardarCliente.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoCliente cliente, @PathVariable Long codigo)
    {
        return this.servicioModificarCliente.ejecutar(cliente,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarCliente.ejecutar(codigo);
    }
}
