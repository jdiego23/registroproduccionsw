package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Driver;

public class DriverTestDataBuilder {
    private int codigo ;
    private String descripcion ;

    public DriverTestDataBuilder() {
        this.codigo = 1234;
        this.descripcion =  "Driver Modelo 1";
    }

    public DriverTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public DriverTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Driver build() {
        return Driver.of(codigo, descripcion);
    }
}
