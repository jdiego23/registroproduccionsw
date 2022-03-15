package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadDriver;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioDriverJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioDriverPostgreSQL implements RepositorioDriver {

    private final RepositorioDriverJpa repositorioDriverJpa;

    public RepositorioDriverPostgreSQL(RepositorioDriverJpa repositorioDriverJpa) {
        this.repositorioDriverJpa = repositorioDriverJpa;
    }

    @Override
    public List<Driver> listar() {
        List<EntidadDriver> entidades= this.repositorioDriverJpa.findAll();
        return entidades.stream().map(entidad -> Driver.of(entidad.getCodigo(), entidad.getDescripcion())).toList();

    }

    @Override
    public Driver consultarPorId(Long id) {
        return this.repositorioDriverJpa.findById(id).map(entidad ->Driver.of(entidad.getCodigo(), entidad.getDescripcion()))
                .orElse(null);
    }

    @Override
    public Long guardar(Driver driver) {
        EntidadDriver entidad = new EntidadDriver(driver.getCodigo(), driver.getDescripcion());
        return this.repositorioDriverJpa.save(entidad).getId();
    }

    @Override
    public boolean existe(Driver driver) {
        return this.repositorioDriverJpa.findByDescripcion(driver.getDescripcion())!= null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioDriverJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Driver driver, Long id) {
       this.repositorioDriverJpa.findById(id);
       EntidadDriver entidad = new EntidadDriver();
       entidad.setCodigo(driver.getCodigo());
       entidad.setDescripcion(driver.getDescripcion());
       entidad.setId(id);
       repositorioDriverJpa.save(entidad);
        return null;
    }
}
