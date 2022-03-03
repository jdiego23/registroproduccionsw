package com.uco.myproject.dominio.servicio.cliente;

import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCliente {

    private static final String MENSAJE_NO_EXISTE = "No existe el Cliente con los datos ingresados";

    private final RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Long codigo) {

        if(this.repositorioCliente.consultarPorId(codigo) == null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        return this.repositorioCliente.eliminar(codigo);
    }
}
