package com.uco.myproject.aplicacion.servicio.modulo;

import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.puerto.RepositorioModulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarModulo {
    private final RepositorioModulo repositorioModulo;

    public ServicioAplicacionListarModulo(RepositorioModulo repositorioModulo) {
        this.repositorioModulo = repositorioModulo;
    }

    public List<Modulo> ejecutar() {
        return this.repositorioModulo.listar();
    }

    public Modulo consultar(Long id) {return this.repositorioModulo.consultarPorId(id);}
}

