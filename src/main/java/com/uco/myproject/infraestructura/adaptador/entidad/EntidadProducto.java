package com.uco.myproject.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class EntidadProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codigo;
    private String nombre;
    private String descripcion;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "modulo_id")
    private EntidadModulo modulo;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Driver_id")
    private EntidadDriver driver;

    public EntidadProducto() {
    }

    public EntidadProducto(int codigo, String nombre, String descripcion, EntidadModulo modulo, EntidadDriver driver) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modulo = modulo;
        this.driver = driver;
    }
}
