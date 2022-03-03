package com.uco.myproject.aplicacion.servicio.cliente;

import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ServicioAplicacionListarCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicioAplicacionListarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> ejecutar() {
        return this.repositorioCliente.listar();
    }

    public Cliente consultar(Long id) {return this.repositorioCliente.consultarPorId(id);}
}
