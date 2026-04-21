package io.acme.moneta.dto.response;

public record UsuarioResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono
) {
}
