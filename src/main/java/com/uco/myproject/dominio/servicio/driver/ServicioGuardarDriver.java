package com.uco.myproject.dominio.servicio.driver;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarDriver {
    private static final String MENSAJE_YA_EXISTE = "El componente driver ya existe";

    private final RepositorioDriver repositorioDriver;

    public ServicioGuardarDriver(RepositorioDriver repositorioDriver) {
        this.repositorioDriver = repositorioDriver;
    }

    public Long ejecutar(Driver driver)
    {
        if(this.repositorioDriver.existe(driver))
        {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioDriver.guardar(driver);
    }
}
