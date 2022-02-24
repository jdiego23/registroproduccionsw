package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.modelo.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<Usuario> listar();
    Usuario consultarPorId(Long id);
    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
}
