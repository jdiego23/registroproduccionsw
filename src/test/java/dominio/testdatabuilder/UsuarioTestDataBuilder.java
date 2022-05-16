package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;

import java.util.Arrays;
import java.util.List;

public class UsuarioTestDataBuilder {

    private String nombre;
    private String apellido;
    private String cargo ;
    private String contrasena ;
    List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

    public UsuarioTestDataBuilder() {
        this.nombre = "juan";
        this.apellido = "valencia";
        this.cargo = "operario";
        this.contrasena = "Assdffg1234";

    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public UsuarioTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }


    public Usuario build() {
        return Usuario.of(nombre, apellido, cargo, contrasena,roles);
    }
}
