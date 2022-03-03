package com.uco.myproject.dominio.servicio.cliente;

import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarCliente {
    private static final String MENSAJE_YA_EXISTE = "Ya existe el Cliente con los datos ingresados";

    private final RepositorioCliente repositorioCliente;

    public ServicioGuardarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {

        if(this.repositorioCliente.existe(cliente)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioCliente.guardar(cliente);
    }
}
