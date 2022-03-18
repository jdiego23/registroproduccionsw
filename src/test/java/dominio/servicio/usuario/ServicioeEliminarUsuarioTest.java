package dominio.servicio.usuario;


import com.uco.myproject.dominio.puerto.RepositorioUsuario;

import com.uco.myproject.dominio.servicio.usuario.ServicioEliminarUsuario;
import dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioeEliminarUsuarioTest {
   @Test
   void verificarNoExistaProducto()
   {
       var usuario = new UsuarioTestDataBuilder().build();

       var repositorio = Mockito.mock(RepositorioUsuario.class);
       var servicio= new ServicioEliminarUsuario(repositorio);

       Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

       Assertions.assertEquals("No existe el Usuario con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(1L)).getMessage());
   }

}
