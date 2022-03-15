package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EnridadDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDriverJpa extends JpaRepository<EnridadDriver,Long > {

    EnridadDriver findByDescripcion(String descripcion);
}
