package dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Cliente;

public class ClienteTestDataBuilder {

    private int nit;
    private String nombre;
    private String  direccion;
    private String pais;


    public ClienteTestDataBuilder() {
        this.nit =123456;
        this.nombre = "UCO";
        this.direccion = "Cra. 46 # 40B-50, Rionegro, Antioquia";
        this.pais = "Colombia";
    }

    public ClienteTestDataBuilder conNit(int nit) {
        this.nit = nit;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ClienteTestDataBuilder conPais(String pais) {
        this.pais = pais;
        return this;
    }

    public Cliente build() {
        return Cliente.of(nit, nombre, direccion, pais);
    }
}
