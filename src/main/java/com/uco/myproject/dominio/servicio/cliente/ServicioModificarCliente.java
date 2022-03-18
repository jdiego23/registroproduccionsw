package com.uco.myproject.dominio.servicio.cliente;

import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarCliente {
    private static final String MENSAJE_YA_EXISTE = "No existe el Cliente con los datos ingresados";

    private final RepositorioCliente repositorioCliente;

    public ServicioModificarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }
    public Long ejecutar(Cliente cliente, Long codigo) {

        if(this.repositorioCliente.consultarPorId(codigo)== null) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }

        return this.repositorioCliente.modificar(cliente,codigo);
    }
}
