package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.modelo.Pedido;
import java.util.List;

public interface RepositorioPedido {
    List<Pedido> listar();
    Pedido consultarPorId(Long id);
    Long guardar(Pedido pedido);
    boolean existe(Pedido pedido);
    Long eliminar(Long id);
    Long modificar(Pedido pedido, Long id);
}
