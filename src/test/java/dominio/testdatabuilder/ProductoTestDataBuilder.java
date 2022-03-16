package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Driver;
import com.uco.myproject.dominio.modelo.Modulo;
import com.uco.myproject.dominio.modelo.Producto;


public class ProductoTestDataBuilder {
    private int codigo;
    private String nombre;
    private String descripcion;
    private Modulo modulo;
    private Driver driver;

    public ProductoTestDataBuilder() {
        this.codigo = 1234;
        this.nombre = "producto 1";
        this.descripcion = "valencia";
        this.modulo = Modulo.of(1234,"Modulo 1");
        this.driver = Driver.of(1234,"Driver 1");
    }

    public ProductoTestDataBuilder conCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }
    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoTestDataBuilder conModulo(Modulo modulo) {
        this.modulo = modulo;
        return this;
    }

    public ProductoTestDataBuilder conDriver(Driver driver) {
        this.driver = driver;
        return this;
    }


    public Producto build() {
        return Producto.of(codigo,nombre,descripcion,modulo,driver);
    }
}
