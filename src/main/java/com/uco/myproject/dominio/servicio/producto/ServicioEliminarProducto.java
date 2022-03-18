package com.uco.myproject.dominio.servicio.producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarProducto {
    private static final String MENSAJE_NO_EXISTE = "No existe el producto con los datos ingresados";

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Long id)
    {
        if(this.repositorioProducto.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return repositorioProducto.eliminar(id);
    }
}
