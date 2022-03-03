package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EntidadCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClienteJpa extends JpaRepository<EntidadCliente, Long> {

    EntidadCliente findByNombreAndDireccion(String nombre, String direccion);
}
