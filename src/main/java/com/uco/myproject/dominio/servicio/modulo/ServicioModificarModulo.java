package com.uco.myproject.dominio.servicio.modulo;

import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.puerto.RepositorioModulo;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarModulo {
    private static final String MENSAJA_NO_EXISTE = "No existe el Componente modulo que se desea modificar";

    private final RepositorioModulo repositorioModulo;

    public ServicioModificarModulo(RepositorioModulo repositorioModulo) {
        this.repositorioModulo = repositorioModulo;
    }

    public Long ejecutar(Modulo modulo, Long id)
    {
        if(this.repositorioModulo.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJA_NO_EXISTE);
        }
        return this.repositorioModulo.modificar(modulo, id);
    }
}
