package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarProducto {
    private static final String MENSAJE_NO_EXISTE = "No existe el Producto con los datos ingresados";

    private final RepositorioProducto repositorioProducto;

    public ServicioModificarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto, Long codigo) {

        if(this.repositorioProducto.consultarPorId(codigo)== null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioProducto.modificar(producto,codigo);
    }
}
