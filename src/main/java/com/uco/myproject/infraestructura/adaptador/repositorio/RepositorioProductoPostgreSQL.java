package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadDriver;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadModulo;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadProducto;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioDriverJpa;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioModuloJpa;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioProductoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProductoPostgreSQL implements RepositorioProducto {
    private final RepositorioProductoJpa repositorioProductoJpa;
    private final RepositorioModuloJpa repositorioModuloJpa;
    private final RepositorioDriverJpa repositorioDriverJpa;

    public RepositorioProductoPostgreSQL(RepositorioProductoJpa repositorioProductoJpa, RepositorioModuloJpa repositorioModuloJpa, RepositorioDriverJpa repositorioDriverJpa) {
        this.repositorioProductoJpa = repositorioProductoJpa;
        this.repositorioModuloJpa = repositorioModuloJpa;
        this.repositorioDriverJpa = repositorioDriverJpa;
    }

    @Override
    public List<Producto> listar() {
        List<EntidadProducto> entidades = repositorioProductoJpa.findAll();
        return entidades.stream().map(entidad-> Producto.of(entidad.getCodigo(), entidad.getNombre(),entidad.getDescripcion(), Modulo.of(entidad.getModulo().getCodigo(),entidad.getModulo().getDescripcion()),
                Driver.of(entidad.getDriver().getCodigo(),entidad.getDriver().getDescripcion()))).toList();

    }

    @Override
    public Producto consultarPorId(Long id) {

        return this.repositorioProductoJpa
                .findById(id)
                .map(entidad ->  Producto.of(entidad.getCodigo(), entidad.getNombre(), entidad.getDescripcion(), Modulo.of(entidad.getModulo().getCodigo(),entidad.getModulo().getDescripcion()),Driver.of(entidad.getDriver().getCodigo(),entidad.getDriver().getDescripcion())))
                .orElse(null);
    }

    @Override
    public Long guardar(Producto producto) {
        EntidadModulo entidadModulo = this.repositorioModuloJpa.findByDescripcion(producto.getModulo().getDescripcion());
        EntidadDriver entidadDriver =this.repositorioDriverJpa.findByDescripcion(producto.getDriver().getDescripcion());

        EntidadProducto entidad = new EntidadProducto(producto.getCodigo(), producto.getNombre(),producto.getDescripcion()
                , entidadModulo, entidadDriver);
        return this.repositorioProductoJpa.save(entidad).getId();
    }

    @Override
    public boolean existe(Producto producto) {
        return this.repositorioProductoJpa.findByNombreAndDescripcion(producto.getNombre(), producto.getDescripcion()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioProductoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Producto producto, Long id) {

        repositorioProductoJpa.findById(id);
        EntidadProducto entidadProducto = new EntidadProducto();
        entidadProducto.setId(id);
        entidadProducto.setCodigo(producto.getCodigo());
        entidadProducto.setNombre(producto.getNombre());
        entidadProducto.setDescripcion(producto.getDescripcion());
        repositorioProductoJpa.save(entidadProducto);
        return id;
    }
}
