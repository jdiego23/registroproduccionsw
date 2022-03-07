package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadUsuario;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class RepositorioUsuarioPostgreSQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;


    public RepositorioUsuarioPostgreSQL(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<Usuario> listar() {
        List<EntidadUsuario> entidades = this.repositorioUsuarioJpa.findAll();
        return entidades.stream().map(entidad -> Usuario.of(entidad.getNombre(), entidad.getApellido(), entidad.getCargo(), entidad.getContrasena())).toList();
    }

    @Override
    public Usuario consultarPorId(Long id) {

       return this.repositorioUsuarioJpa
               .findById(id)
               .map(entidad -> Usuario.of(entidad.getNombre(), entidad.getApellido(), entidad.getCargo(), entidad.getContrasena()))
               .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {

       EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCargo(), usuario.getContrasena());

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();

    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setCargo(usuario.getCargo());
        entidadUsuario.setContrasena(usuario.getContrasena());
        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }
}
