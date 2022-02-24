package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadUsuario;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioUsuarioMysql(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<Usuario> listar() {
        List<EntidadUsuario> entidades = this.repositorioUsuarioJpa.findAll();
        return entidades.stream().map(entidad -> Usuario.of(entidad.getNombre(), entidad.getApellido())).toList();
    }

    @Override
    public Usuario consultarPorId(Long id) {

       return this.repositorioUsuarioJpa
               .findById(id)
               .map(entidad -> Usuario.of(entidad.getNombre(), entidad.getApellido()))
               .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {

        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido());

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();
    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) != null;
    }
}
