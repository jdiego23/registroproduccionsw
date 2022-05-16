package com.uco.myproject.infraestructura.controlador;


import com.uco.myproject.aplicacion.dto.DtoProducto;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionEliminarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionGuardarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionListarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionModificarProducto;

import com.uco.myproject.dominio.modelo.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ControladorProducto {
    private final ServicioAplicacionListarProducto servicioListarProductos;
    private final ServicioAplicacionEliminarProducto servicioEliminarProducto;
    private final ServicioAplicacionModificarProducto servicioModificarProducto;
    private final ServicioAplicacionGuardarProducto servicioGuardarProducto;

    public ControladorProducto(ServicioAplicacionListarProducto servicioListarProductos, ServicioAplicacionEliminarProducto servicioEliminarProducto, ServicioAplicacionModificarProducto servicioModificarProducto, ServicioAplicacionGuardarProducto servicioGuardarProducto) {
        this.servicioListarProductos = servicioListarProductos;
        this.servicioEliminarProducto = servicioEliminarProducto;
        this.servicioModificarProducto = servicioModificarProducto;
        this.servicioGuardarProducto = servicioGuardarProducto;
    }
    @GetMapping
    public List<Producto> listar() {
        return servicioListarProductos.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Producto listar(@PathVariable Long codigo ) {
        return servicioListarProductos.consultar(codigo);
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoProducto dto) {
        return this.servicioGuardarProducto.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoProducto producto, @PathVariable Long codigo)
    {
        return this.servicioModificarProducto.ejecutar(producto,codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarProducto.ejecutar(codigo);
    }
}
