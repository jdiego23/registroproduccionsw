package com.uco.myproject.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "modulo")
public class EntidadModulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codigo;
    private String descripcion;


    public EntidadModulo() {
    }

    public EntidadModulo(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

}
