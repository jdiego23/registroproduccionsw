package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.modelo.Modulo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioModulo {
    List<Modulo> listar();
    Modulo consultarPorId(Long id);
    Long guardar(Modulo modulo);
    boolean existe(Modulo modulo);
    Long eliminar(Long id);
    Long modificar(Modulo modulo, Long id);
}
