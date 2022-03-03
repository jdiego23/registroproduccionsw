package com.uco.myproject.aplicacion.servicio.cliente;

import com.uco.myproject.aplicacion.dto.DtoCliente;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.servicio.cliente.ServicioGuardarCliente;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarCliente {
    private final ServicioGuardarCliente servicioGuardarCliente;

    public ServicioAplicacionGuardarCliente(ServicioGuardarCliente servicioGuardarCliente) {
        this.servicioGuardarCliente = servicioGuardarCliente;
    }

    public DtoRespuesta<Long> ejecutar(DtoCliente dto) {

        Cliente cliente = Cliente.of(dto.getNit(), dto.getNombre(), dto.getDireccion(), dto.getPais());
        return new DtoRespuesta<>(this.servicioGuardarCliente.ejecutar(cliente));
    }
}
