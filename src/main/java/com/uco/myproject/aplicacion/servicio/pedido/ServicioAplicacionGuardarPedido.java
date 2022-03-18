package com.uco.myproject.aplicacion.servicio.pedido;

import com.uco.myproject.aplicacion.dto.DtoPedido;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.*;
import com.uco.myproject.dominio.servicio.pedido.ServicioGuardarPedido;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPedido {
    private final ServicioGuardarPedido servicioGuardarPedido;

    public ServicioAplicacionGuardarPedido(ServicioGuardarPedido servicioGuardarPedido) {
        this.servicioGuardarPedido = servicioGuardarPedido;
    }

    public DtoRespuesta<Long> ejecutar(DtoPedido dto) {
        Modulo modulo = Modulo.of(dto.getProducto().getModulo().getCodigo(),dto.getProducto().getModulo().getDescripcion());
        Driver driver = Driver.of(dto.getProducto().getDriver().getCodigo(),dto.getProducto().getDriver().getDescripcion());
        Producto producto = Producto.of(dto.getProducto().getCodigo(),dto.getProducto().getNombre(),dto.getProducto().getDescripcion(),modulo,driver);
        Cliente cliente = Cliente.of(dto.getCliente().getNit(),dto.getCliente().getNombre(),dto.getCliente().getDireccion(),dto.getCliente().getPais());

        Pedido pedido = Pedido.of(dto.getNumero(), cliente,producto, dto.getCantidad());

        return new DtoRespuesta<>(this.servicioGuardarPedido.ejecutar(pedido));
    }
}
