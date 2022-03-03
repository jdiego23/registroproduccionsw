package com.uco.myproject.infraestructura.adaptador.entidad;

import javax.persistence.*;

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

    public EntidadUsuario() {}

    public EntidadUsuario(String nombre, String apellido, String cargo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Long getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId(Long id) {this.id = id;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public void setCargo(String cargo) {this.cargo = cargo;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
}
