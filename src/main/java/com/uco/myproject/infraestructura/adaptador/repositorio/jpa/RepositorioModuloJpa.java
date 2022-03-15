package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EntidadModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioModuloJpa extends JpaRepository<EntidadModulo,Long> {

    EntidadModulo findByDescripcion(String descripcion);
}
