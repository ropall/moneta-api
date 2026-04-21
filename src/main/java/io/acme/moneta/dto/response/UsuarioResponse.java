package io.acme.moneta.dto.response;

import io.acme.moneta.dominio.enums.EstadoUsuario;
import io.acme.moneta.dominio.enums.Rol;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        Rol rol,
        EstadoUsuario estado,
        LocalDateTime fechaCreacion
) { }
