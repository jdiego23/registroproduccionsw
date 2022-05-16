package com.uco.myproject.infraestructura.adaptador.servicio;

import com.uco.myproject.dominio.servicio.ServicioCifrarTexto;
import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

@Component
public class ServicioCifrarTextoSha256 implements ServicioCifrarTexto {
    @Override
    public String ejecutar(String texto) {
        return DigestUtils.sha256Hex(texto);
    }
}
