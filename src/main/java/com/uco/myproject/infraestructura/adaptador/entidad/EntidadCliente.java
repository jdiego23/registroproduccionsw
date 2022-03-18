package com.uco.myproject.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class EntidadCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nit;
    private String nombre;
    private String direccion;
    private String pais;

    public EntidadCliente() {}

    public EntidadCliente(int nit, String nombre, String direccion, String pais) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
    }
}
