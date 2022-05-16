package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.dominio.modelo.Usuario;
import java.util.List;

public interface RepositorioUsuario {

    List<DtoUsuarioResumen> listar();
    DtoUsuarioResumen consultarPorId(Long id);
    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Long modificar(Usuario usuario, Long id);
    Usuario consultar(String usuario, String clave);

}
