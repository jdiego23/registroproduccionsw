package com.uco.myproject.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private String cargo;
    private String contrasena;

    public EntidadUsuario() {}

    public EntidadUsuario(Long id, String nombre, String apellido, String cargo, String contrasena) {
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
}
