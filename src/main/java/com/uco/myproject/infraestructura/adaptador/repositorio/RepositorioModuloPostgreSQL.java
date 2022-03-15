package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.puerto.RepositorioModulo;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadModulo;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioModuloJpa;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class RepositorioModuloPostgreSQL implements RepositorioModulo {

    private final RepositorioModuloJpa repositorioModuloJpa;

    public RepositorioModuloPostgreSQL(RepositorioModuloJpa repositorioModuloJpa) {
        this.repositorioModuloJpa = repositorioModuloJpa;
    }

    @Override
    public List<Modulo> listar() {
        List<EntidadModulo> entidades = repositorioModuloJpa.findAll();
        return entidades.stream().map(entidad -> Modulo.of(entidad.getCodigo(), entidad.getDescripcion())).toList();
    }

    @Override
    public Modulo consultarPorId(Long id) {
        return this.repositorioModuloJpa.findById(id).map(entidad ->Modulo.of(entidad.getCodigo(), entidad.getDescripcion()))
                .orElse(null);
    }

    @Override
    public Long guardar(Modulo modulo) {
        EntidadModulo entidad = new EntidadModulo(modulo.getCodigo(), modulo.getDescripcion());
        return this.repositorioModuloJpa.save(entidad).getId();
    }

    @Override
    public boolean existe(Modulo modulo) {
        return this.repositorioModuloJpa.findByDescripcion(modulo.getDescripcion())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioModuloJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Modulo modulo, Long id) {
        repositorioModuloJpa.findById(id);
        EntidadModulo entidadModulo = new EntidadModulo();
        entidadModulo.setId(id);
        entidadModulo.setCodigo(modulo.getCodigo());
        entidadModulo.setDescripcion(modulo.getDescripcion());
        repositorioModuloJpa.save(entidadModulo);
        return id;
    }
}
