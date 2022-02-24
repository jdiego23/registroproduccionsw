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

    public EntidadUsuario() {}

    public EntidadUsuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
}
