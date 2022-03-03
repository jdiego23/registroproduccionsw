package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.modelo.Cliente;


import java.util.List;

public interface RepositorioCliente {
    List<Cliente> listar();
    Cliente consultarPorId(Long id);
    Long guardar(Cliente cliente);
    boolean existe(Cliente cliente);
    Long eliminar(Long id);
    Long modificar(Cliente cliente, Long id);
}
