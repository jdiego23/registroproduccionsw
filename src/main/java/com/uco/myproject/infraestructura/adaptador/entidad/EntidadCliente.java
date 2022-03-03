package com.uco.myproject.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class EntidadCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nit;
    private String nombre;
    private String direccion;
    private String pais;

    public EntidadCliente() {}

    public EntidadCliente(int nit, String nombre, String direccion, String pais) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getNit() {return nit;}

    public void setNit(int nit) {this.nit = nit;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getPais() {return pais;}

    public void setPais(String pais) {this.pais = pais;}
}
