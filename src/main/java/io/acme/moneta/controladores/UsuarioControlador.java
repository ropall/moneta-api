package io.acme.moneta.controladores;

import io.acme.moneta.dto.request.UsuarioRegistroRequest;
import io.acme.moneta.dto.response.UsuarioResponse;
import io.acme.moneta.servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios") //ruta base para todos los metodos
@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRegistroRequest request){

        UsuarioResponse respuesta = usuarioServicio.registrarUsuario(request);

        return ResponseEntity.status(HttpStatus.CREATED). body(respuesta);
    }
}
