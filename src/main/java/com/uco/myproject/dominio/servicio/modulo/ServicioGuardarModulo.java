package com.uco.myproject.dominio.servicio.modulo;

import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.puerto.RepositorioModulo;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarModulo {
    private static final String MENSAJE_YA_EXISTE = "El componente modulo ya existe";

    private final RepositorioModulo repositorioModulo;

    public ServicioGuardarModulo(RepositorioModulo repositorioModulo) {
        this.repositorioModulo = repositorioModulo;
    }

    public Long ejecutar(Modulo modulo)
    {
        if(this.repositorioModulo.existe(modulo) == true)
        {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioModulo.guardar(modulo);
    }

}
