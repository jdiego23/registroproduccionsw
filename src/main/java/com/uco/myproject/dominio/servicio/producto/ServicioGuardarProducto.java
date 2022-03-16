package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.modelo.Producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;

import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarProducto {
    private static final String MENSAJE_YA_EXISTE = "Ya existe el Producto con los datos ingresados";

    private final RepositorioProducto repositorioProducto;

    public ServicioGuardarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {

        if(this.repositorioProducto.existe(producto)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioProducto.guardar(producto);
    }
}
