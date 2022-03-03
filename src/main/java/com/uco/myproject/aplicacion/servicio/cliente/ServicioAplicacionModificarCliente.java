package com.uco.myproject.aplicacion.servicio.cliente;

import com.uco.myproject.aplicacion.dto.DtoCliente;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.servicio.cliente.ServicioModificarCliente;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarCliente {
    private final ServicioModificarCliente servicioModificarCliente;

    public ServicioAplicacionModificarCliente(ServicioModificarCliente servicioModificarCliente) {
        this.servicioModificarCliente = servicioModificarCliente;
    }

    public DtoRespuesta<Long> ejecutar(DtoCliente dto, Long codigo) {

        Cliente cliente = Cliente.of(dto.getNit(), dto.getNombre(), dto.getDireccion(), dto.getPais());

        return new DtoRespuesta<>(this.servicioModificarCliente.ejecutar(cliente, codigo));
    }
}
