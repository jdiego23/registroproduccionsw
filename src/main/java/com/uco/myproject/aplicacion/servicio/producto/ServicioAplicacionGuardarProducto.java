package com.uco.myproject.aplicacion.servicio.producto;

import com.uco.myproject.aplicacion.dto.DtoProducto;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.servicio.producto.ServicioGuardarProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProducto {
    private final ServicioGuardarProducto servicioGuardarProducto;

    public ServicioAplicacionGuardarProducto(ServicioGuardarProducto servicioGuardarProducto) {
        this.servicioGuardarProducto = servicioGuardarProducto;
    }

    public DtoRespuesta<Long> ejecutar(DtoProducto dto) {

        Producto producto = Producto.of(dto.getCodigo(), dto.getNombre(),dto.getDescripcion(), Modulo.of(dto.getModulo().getCodigo(),dto.getModulo().getDescripcion()), Driver.of(dto.getDriver().getCodigo(),dto.getDriver().getDescripcion()));

        return new DtoRespuesta<>(this.servicioGuardarProducto.ejecutar(producto));
    }
}
