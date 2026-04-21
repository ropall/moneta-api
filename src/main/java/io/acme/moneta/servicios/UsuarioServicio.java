package io.acme.moneta.servicios;
import io.acme.moneta.dominio.modelos.Usuario;
import io.acme.moneta.dto.request.UsuarioRegistroRequest;
import io.acme.moneta.dto.response.UsuarioResponse;
import io.acme.moneta.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {


    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioResponse registrarUsuario(UsuarioRegistroRequest request){
        //Verificar que el email no esta en Uso
        if (usuarioRepositorio.existsByEmail(request.email())){
            throw new IllegalArgumentException("El email ya esta Registrado");
        }
        //Transformar el DTO  a la entidad
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(request.nombre());
        nuevoUsuario.setApellido(request.apellido());
        nuevoUsuario.setEmail(request.email());
        nuevoUsuario.setTelefono(request.telefono());
        nuevoUsuario.setPassword(request.password()); //TODO  aqui encriptaremos las contraseñas mas adelante

        //Guardar en la base de datos a traves del repositorio
        Usuario usuarioGuardado = usuarioRepositorio.save(nuevoUsuario);

        //Ahora vamos a tranformar la entidad guardada en el DTO de respuesta
        return new UsuarioResponse(
                usuarioGuardado.getId(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getApellido(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getTelefono()
        );
    }

}
