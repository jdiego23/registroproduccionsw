package com.uco.myproject.dominio.servicio.driver;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarDriver {
    private static final String MENSAJA_NO_EXISTE = "No existe el Componente Driver que se desea modificar";

    private final RepositorioDriver repositorioDriver;

    public ServicioModificarDriver(RepositorioDriver repositorioDriver) {
        this.repositorioDriver = repositorioDriver;
    }

    public Long ejecutar(Driver driver,Long id)
    {
        if(this.repositorioDriver.consultarPorId(id)== null)
        {
            throw new IllegalStateException(MENSAJA_NO_EXISTE);
        }
        return this.repositorioDriver.modificar(driver,id);
    }
}
