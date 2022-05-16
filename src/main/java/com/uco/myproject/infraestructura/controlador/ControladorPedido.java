package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoPedido;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.pedido.ServicioAplicacionEliminarPedido;
import com.uco.myproject.aplicacion.servicio.pedido.ServicioAplicacionGuardarPedido;
import com.uco.myproject.aplicacion.servicio.pedido.ServicioAplicacionListarPedido;
import com.uco.myproject.aplicacion.servicio.pedido.ServicioAplicacionesModificarPedido;
import com.uco.myproject.dominio.modelo.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pedidos")
public class ControladorPedido {
    private final ServicioAplicacionListarPedido servicioListarPedido;
    private final ServicioAplicacionGuardarPedido servicioGuardarPedido;
    private final ServicioAplicacionesModificarPedido servicioModificarPedido;
    private final ServicioAplicacionEliminarPedido  servicioEliminarPedido;

    public ControladorPedido(ServicioAplicacionListarPedido servicioListarPedido, ServicioAplicacionGuardarPedido servicioGuardarPedido, ServicioAplicacionesModificarPedido servicioModificarPedido, ServicioAplicacionEliminarPedido servicioEliminarPedido) {
        this.servicioListarPedido = servicioListarPedido;
        this.servicioGuardarPedido = servicioGuardarPedido;
        this.servicioModificarPedido = servicioModificarPedido;
        this.servicioEliminarPedido = servicioEliminarPedido;
    }
    @GetMapping
    public List<Pedido> listar() {
        return servicioListarPedido.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Pedido listar(@PathVariable Long codigo ) {
        return servicioListarPedido.consultar(codigo);
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPedido dto) {
        return this.servicioGuardarPedido.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoPedido pedido, @PathVariable Long codigo)
    {
        return this.servicioModificarPedido.ejecutar(pedido,codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarPedido.ejecutar(codigo);
    }
}
