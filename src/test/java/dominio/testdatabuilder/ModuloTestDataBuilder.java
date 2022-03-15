package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Modulo;

public class ModuloTestDataBuilder {
    private int codigo ;
    private String descripcion ;

    public ModuloTestDataBuilder() {
        this.codigo = 1234;
        this.descripcion =  "Driver Modelo 1";
    }

    public ModuloTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public ModuloTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Modulo build() {return Modulo.of(codigo, descripcion);}
}
