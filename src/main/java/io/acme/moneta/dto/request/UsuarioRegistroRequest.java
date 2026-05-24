package io.acme.moneta.dto.request;

import jakarta.validation.constraints.Pattern;

import javax.swing.*;

public record UsuarioRegistroRequest(
        String  nombre,
        String apellido,
        String email,

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "El teléfono no es válido")
        String telefono,
        String password
) {
}
