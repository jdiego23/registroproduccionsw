package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EntidadPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedidoJpa  extends JpaRepository<EntidadPedido, Long> {

    EntidadPedido findByNumero(int numero);
}
