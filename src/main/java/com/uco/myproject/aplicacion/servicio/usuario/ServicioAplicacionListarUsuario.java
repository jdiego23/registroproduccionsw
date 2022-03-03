package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> ejecutar() {
        return this.repositorioUsuario.listar();
    }

    public Usuario consultar(Long id) {return this.repositorioUsuario.consultarPorId(id);}
}
