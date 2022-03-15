package com.uco.myproject.aplicacion.servicio.driver;


import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.puerto.RepositorioDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarDriver {
    private final RepositorioDriver repositorioDriver;

    public ServicioAplicacionListarDriver(RepositorioDriver repositoriodriver) {
        this.repositorioDriver = repositoriodriver;
    }

    public List<Driver> ejecutar() {
        return this.repositorioDriver.listar();
    }

    public Driver consultar(Long id) {return this.repositorioDriver.consultarPorId(id);}
}
