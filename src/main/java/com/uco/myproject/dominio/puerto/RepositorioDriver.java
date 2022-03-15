package com.uco.myproject.dominio.puerto;
import com.uco.myproject.dominio.modelo.Driver;

import java.util.List;

public interface RepositorioDriver {
    List<Driver> listar();
    Driver consultarPorId(Long id);
    Long guardar(Driver driver);
    boolean existe(Driver driver);
    Long eliminar(Long id);
    Long modificar(Driver driver, Long id);
}
