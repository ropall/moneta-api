package io.acme.moneta.dto.response;

import io.acme.moneta.dominio.enums.Rol;

public record UsuarioResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        Rol rol
) {
}
