package com.uco.myproject.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "id_usuario")
    private List<EntidadRolUsuario> roles;

    public EntidadUsuario() {}

    public EntidadUsuario(String nombre, String apellido, String cargo, String contrasena, List<EntidadRolUsuario> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
        this.roles = roles;
    }

}
