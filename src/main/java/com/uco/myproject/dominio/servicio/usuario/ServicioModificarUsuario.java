package com.uco.myproject.dominio.servicio.usuario;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarUsuario {
    private static final String MENSAJE_NO_EXISTE = "No existe el Usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioModificarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario, Long codigo) {

        if(this.repositorioUsuario.consultarPorId(codigo)== null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        return this.repositorioUsuario.modificar(usuario,codigo);
    }
}
