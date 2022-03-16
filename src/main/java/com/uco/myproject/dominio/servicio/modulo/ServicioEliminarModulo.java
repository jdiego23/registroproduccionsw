package com.uco.myproject.dominio.servicio.modulo;

import com.uco.myproject.dominio.puerto.RepositorioModulo;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarModulo {

    private static final String MENSAJE_NO_EXISTE = "No existe el Componente modulo con los datos ingresados";

    private final RepositorioModulo repositorioModulo;

    public ServicioEliminarModulo(RepositorioModulo repositorioModulo) {
        this.repositorioModulo = repositorioModulo;
    }

    public Long ejecutar(Long id)
    {
        if(this.repositorioModulo.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return repositorioModulo.eliminar(id);
    }
}
