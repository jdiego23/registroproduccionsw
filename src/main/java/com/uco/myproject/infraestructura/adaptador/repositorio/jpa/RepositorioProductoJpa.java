package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;


import com.uco.myproject.infraestructura.adaptador.entidad.EntidadProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProductoJpa extends JpaRepository<EntidadProducto, Long> {

    EntidadProducto findByNombreAndDescripcion(String nombre, String descripcion);
}
