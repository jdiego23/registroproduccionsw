package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Cliente;
import com.uco.myproject.dominio.puerto.RepositorioCliente;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadCliente;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioClienteJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClientePostgreSQL implements RepositorioCliente {

    private final RepositorioClienteJpa repositorioClienteJpa;

    public RepositorioClientePostgreSQL(RepositorioClienteJpa repositorioClienteJpa) {
        this.repositorioClienteJpa = repositorioClienteJpa;
    }

    @Override
    public List<Cliente> listar() {
        List<EntidadCliente> entidades = this.repositorioClienteJpa.findAll();
        return entidades.stream().map(entidad -> Cliente.of(entidad.getNit(),entidad.getNombre(), entidad.getDireccion(), entidad.getPais())).toList();
    }

    @Override
    public Cliente consultarPorId(Long id) {
        return this.repositorioClienteJpa
                .findById(id)
                .map(entidad -> Cliente.of(entidad.getNit(),entidad.getNombre(), entidad.getDireccion(), entidad.getPais()))
                .orElse(null);
    }

    @Override
    public Long guardar(Cliente cliente) {
        EntidadCliente entidadCliente  = new EntidadCliente(cliente.getNit(),cliente.getNombre(), cliente.getDireccion(), cliente.getPais());

        return this.repositorioClienteJpa.save(entidadCliente).getId();
    }

    @Override
    public boolean existe(Cliente cliente) {
        return this.repositorioClienteJpa.findByNombreAndDireccion(cliente.getNombre(), cliente.getDireccion()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioClienteJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Cliente cliente, Long id) {
        return null;
    }
}
