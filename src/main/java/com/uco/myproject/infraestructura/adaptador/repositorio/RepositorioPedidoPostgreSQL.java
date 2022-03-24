package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.*;
import com.uco.myproject.dominio.puerto.RepositorioPedido;
import com.uco.myproject.infraestructura.adaptador.entidad.*;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPedidoPostgreSQL implements RepositorioPedido {
    private static final String MENSAJE_NO_EXISTE = "No existe algunos de los componentes con los datos ingresados";

    private final RepositorioPedidoJpa repositorioPedidoJpa;
    private final RepositorioClienteJpa repositorioClienteJpa;
    private final RepositorioProductoJpa repositorioProductoJpa;



    public RepositorioPedidoPostgreSQL(RepositorioPedidoJpa repositorioPedidoJpa, RepositorioClienteJpa repositorioClienteJpa, RepositorioProductoJpa repositorioProductoJpa) {
        this.repositorioPedidoJpa = repositorioPedidoJpa;
        this.repositorioClienteJpa = repositorioClienteJpa;
        this.repositorioProductoJpa = repositorioProductoJpa;

    }


    @Override
    public List<Pedido> listar() {
        List<EntidadPedido> entidades = this.repositorioPedidoJpa.findAll();
        return entidades.stream().map(entidad-> Pedido.of(entidad.getNumero(),
                Cliente.of(entidad.getCliente().getNit(),entidad.getCliente().getNombre(),entidad.getCliente().getDireccion(),entidad.getCliente().getPais()),
                Producto.of(entidad.getProducto().getCodigo(),entidad.getProducto().getNombre(),entidad.getProducto().getDescripcion(),
                        Modulo.of(entidad.getProducto().getModulo().getCodigo(),entidad.getProducto().getModulo().getDescripcion()),
                        Driver.of(entidad.getProducto().getDriver().getCodigo(),entidad.getProducto().getDriver().getDescripcion())),entidad.getCantidad())).toList();
    }

    @Override
    public Pedido consultarPorId(Long id) {
        return this.repositorioPedidoJpa
                .findById(id)
                .map(entidad ->Pedido.of(entidad.getNumero(),
                        Cliente.of(entidad.getCliente().getNit(),entidad.getCliente().getNombre(),entidad.getCliente().getDireccion(),entidad.getCliente().getPais()),
                        Producto.of(entidad.getProducto().getCodigo(),entidad.getProducto().getNombre(),entidad.getProducto().getDescripcion(),
                                Modulo.of(entidad.getProducto().getModulo().getCodigo(),entidad.getProducto().getModulo().getDescripcion()),
                                Driver.of(entidad.getProducto().getDriver().getCodigo(),entidad.getProducto().getDriver().getDescripcion())),entidad.getCantidad()))
                .orElse(null);
    }

    @Override
    public Long guardar(Pedido pedido) {

        EntidadProducto entidadProducto = this.repositorioProductoJpa.findByNombreAndDescripcion(pedido.getProducto().getNombre(),pedido.getProducto().getDescripcion());
        EntidadCliente entidadCliente = this.repositorioClienteJpa.findByNombreAndDireccion(pedido.getCliente().getNombre(),pedido.getCliente().getDireccion());
        if(entidadProducto == null || entidadCliente == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        EntidadPedido entidadPedido = new EntidadPedido(pedido.getNumero(), entidadCliente,entidadProducto, pedido.getCantidad());

        return this.repositorioPedidoJpa.save(entidadPedido).getId();
    }

    @Override
    public boolean existe(Pedido pedido) {
        return this.repositorioPedidoJpa.findByNumero(pedido.getNumero())!= null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioPedidoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pedido pedido, Long id) {
        repositorioPedidoJpa.findById(id);
        EntidadProducto entidadProducto = this.repositorioProductoJpa.findByNombreAndDescripcion(pedido.getProducto().getNombre(),pedido.getProducto().getDescripcion());
        EntidadCliente entidadCliente = this.repositorioClienteJpa.findByNombreAndDireccion(pedido.getCliente().getNombre(),pedido.getCliente().getDireccion());

        if(entidadProducto == null || entidadCliente == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        EntidadPedido entidadPedido = new EntidadPedido();
        entidadPedido.setId(id);
        entidadPedido.setNumero(pedido.getNumero());
        entidadPedido.setCantidad(pedido.getCantidad());

        entidadPedido.setCliente(entidadCliente);

        entidadPedido.setProducto(entidadProducto);

        repositorioPedidoJpa.save(entidadPedido);
        return id;
    }
}
