package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadRolUsuario;
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
    public List<DtoUsuarioResumen> listar() {
        List<EntidadUsuario> entidades = this.repositorioUsuarioJpa.findAll();
        return entidades.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombre(), entidad.getApellido(), entidad.getCargo())).toList();
    }

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

       return this.repositorioUsuarioJpa
               .findById(id)
               .map(entidad -> new DtoUsuarioResumen(entidad.getNombre(), entidad.getApellido(), entidad.getCargo()))
               .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {

        List<EntidadRolUsuario> roles = usuario.getRoles().stream().map(rol -> new EntidadRolUsuario(rol.getRol())).toList();
       EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCargo(), usuario.getContrasena(),roles);

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
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setCargo(usuario.getCargo());
        entidadUsuario.setContrasena(usuario.getContrasena());
        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }

    @Override
    public Usuario consultar(String usuario, String clave) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndContrasena(usuario, clave);

        if(entidadUsuario == null) {
            return null;
        }

        List<RolUsuario> roles = entidadUsuario.getRoles().stream().map(rol -> RolUsuario.of(rol.getRol())).toList();

        return Usuario.of(entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getCargo(), entidadUsuario.getContrasena(), roles);
    }
}
