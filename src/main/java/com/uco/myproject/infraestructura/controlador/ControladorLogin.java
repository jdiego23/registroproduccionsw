package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.login.ServicioAplicacionLogin;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login")
public class ControladorLogin {

    private final ServicioAplicacionLogin servicioAplicacionLogin;

    public ControladorLogin(ServicioAplicacionLogin servicioAplicacionLogin) {
        this.servicioAplicacionLogin = servicioAplicacionLogin;
    }

    @PostMapping
    public DtoRespuesta<String> login(@RequestBody DtoLogin dto) {
        return this.servicioAplicacionLogin.ejecutar(dto);
    }

}
