package com.uco.myproject.dominio.servicio.driver;

import com.uco.myproject.dominio.puerto.RepositorioDriver;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarDriver {
    private static final String MENSAJE_NO_EXISTE = "No existe el Componente Driver con los datos ingresados";

    private final RepositorioDriver repositorioDriver;

    public ServicioEliminarDriver(RepositorioDriver repositorioDriver) {
        this.repositorioDriver = repositorioDriver;
    }

    public Long ejecutar(Long codigo) {

        if(this.repositorioDriver.consultarPorId(codigo) == null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        return this.repositorioDriver.eliminar(codigo);
    }
}
